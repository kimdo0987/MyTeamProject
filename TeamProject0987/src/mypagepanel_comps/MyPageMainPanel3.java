package mypagepanel_comps;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import database.OjdbcConnection;
import panels.ImagePanel;
import panels.MainPanel;
import popups.DeleteChkPopup;

//나의 장바구니 Panel이 될 JPanel입니다

public class MyPageMainPanel3 extends ImagePanel {
	
	static JTable table;
	ArrayList<Integer> checkedRows;
	public int rowSize;
	public String[] couponArr;
	public Integer[] discountRate;
	public ArrayList<String> arrList;
	static JTable table2;
	JComboBox newComboBox; 
	private int rowrow;
	private int colcol;
	Object a;
	public int total_price = 0;
	
	static final HashMap<String, Integer> couponMap= new HashMap <String, Integer>(){{
		put("강좌 10% 할인쿠폰", 10);
		put("강좌 15% 할인쿠폰",15);
		put("강좌 20% 할인쿠폰",20);
		put("강좌 25% 할인쿠폰",25);
		put("연계결제 할인쿠폰",10);
		put("취준/대학생 할인쿠폰",20);
		put("고등학생 할인쿠폰",20);
		put("여름방학 할인쿠폰",10);
		put("겨울방학 할인쿠폰",10);
		put("봄맞이 할인쿠폰",10);
		put("",0);
		put("선택안함",0);
		put("---쿠폰선택---",0);
		put("null",0);
		}};

	
	public MyPageMainPanel3() {
		setBackground(new Color(255, 153, 204));
		setBounds(118, 0, 1093, 800);
		setLayout(null);
		
		JPanel panel = new JPanel(); //장바구니List 테이블과 label이 들어가는 패널 (장바구니 panel)
		panel.setBounds(80, 155, 800, 510);
		panel.setLayout(null);
		add(panel);
		
		JLabel tableNameLabel = new JLabel("장바구니 리스트");
		tableNameLabel.setForeground(Color.WHITE);
		tableNameLabel.setBounds(80, 40, 421, 90);
		add(tableNameLabel);
		tableNameLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 58));
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(0, 0, 800, 510);		
		tablePanel.setLayout(null);
		panel.add(tablePanel);
		
		JTable table = new JTable(); // 수정불가능한 테이블로 생성
		
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch(column) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};

		table.setModel(model);
//		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		
		//headings 설정
		model.addColumn("선택");
		model.addColumn("강의명");
		model.addColumn("강사명");
		model.addColumn("수강 기간");
		model.addColumn("수강료");
		model.addColumn("장바구니");
		
		//row 넣을 data
		String[][] data = database.MyWishLists.getMyWishLists();
		
		//the row
		for (int i = 0; i < data.length; i++) {
			model.addRow(new Object[0]); 
			model.setValueAt(false, i, 0); // checkbox 의 boolean type 이 되는데, true - 체크됨, false - 체크안됨
			//data
			model.setValueAt(data[i][0], i, 1); // (data[row][column], 위치 row번째 행, 위치 column)
			model.setValueAt(data[i][1], i, 2);
			model.setValueAt(data[i][2], i, 3);
			model.setValueAt(data[i][3], i, 4);
			model.setValueAt("삭제하기", i, 5);
		}
		
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(0).setMaxWidth(40);
		table.getColumnModel().getColumn(1).setMinWidth(330);//셀 너비 조정
		table.getColumnModel().getColumn(1).setMaxWidth(300);
		table.getColumnModel().getColumn(2).setMinWidth(120);
		table.getColumnModel().getColumn(2).setMaxWidth(120);
		
		table.getColumnModel().getColumn(3).setMinWidth(130);
		table.getColumnModel().getColumn(3).setMaxWidth(130);
		table.getColumnModel().getColumn(4).setMinWidth(90);
		table.getColumnModel().getColumn(4).setMaxWidth(90);
		table.getColumnModel().getColumn(5).setMinWidth(90);
		table.getColumnModel().getColumn(5).setMaxWidth(90);
		
		///////////////////////////////////////////////////////
		
		MyRenderer cellRenderer = new MyRenderer();
		
//		table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);
		
		table.setEnabled(true); //셀이 선택될 때 파란색으로 뜨는게 없어집니다.
		table.setSelectionBackground(Color.WHITE);
		
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	// getPoint 는 좌표를 뽑아오는건데 rowAtPoint, columnAtPoint 는 
		    	// 행과 열의 범위를 좌표화해서 뽑아옵니다.
		    	/*
		    	
					int javax.swing.JTable.rowAtPoint(Point point)
					
					Returns the index of the row that point lies in,or -1 
					if the result is not in the range[0, getRowCount()-1].
					
					Parameters:point the location of interestReturns:
					the index of the row that point lies in,or -1 
					if the result is not in the range[0, getRowCount()-1]
					
					See Also:columnAtPoint 
					
		    	*/
		        int row = table.rowAtPoint(e.getPoint());
		        int col = table.columnAtPoint(e.getPoint());
		        //System.out.println(row + "and" + col);
		        
		        String cell = ""; 
		        
		        if (row >= 0 && col >= 0) {
		            if (col == 5) {
		            	// 셀을 선택하면 이 테이블의 좌표가 (row, 0)인 값을 String 으로 cell 에 값을 저장함
		            	// -> 이렇게 cell 을 여기다 추가하면 삭제하기 버튼을 누를때 그 행의 강의명을 얻을 수 있음
		            	cell = table.getModel().getValueAt(row, 1).toString();
		            	System.out.println(cell);
		            	DeleteChkPopup.currLectureName = cell ;
		            	new DeleteChkPopup(MainPanel.thisFrame,cell);
		            }
		        }
		    }
		    
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		    	//table.setFont(new Font("Serif", Font.PLAIN, 13));
		    	cellRenderer.colAtMouse = -1;
		    }
		});
		
		// 테이블에서 마우스 커서 적용 먹이려면 모션리스너 -> Moved 이벤트로 해야 먹일 수 있습니다 
		// (다른 리스너,이벤트론 안됨)
		table.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
		        int col = table.columnAtPoint(e.getPoint());
		        if (row >= 0 && col >= 0) {
		        	cellRenderer.rowAtMouse = row;
		        	cellRenderer.color = new Color(246,246,246);
		        	table.repaint();

		        	
		        	Font font = (new Font("맑은 고딕", Font.PLAIN, 14));
		    		
					Map attributes = font.getAttributes();
					attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		        	
		        	if(col == 5) {
		        		setCursor(new Cursor(Cursor.HAND_CURSOR));
		        		cellRenderer.colAtMouse = col;
		        		cellRenderer.fontunderLine = font.deriveFont(attributes);

		        	} else {
		        		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		        		//table.setFont(new Font("Serif", Font.PLAIN, 13));
		        		cellRenderer.colAtMouse = -1;
		        	}		        	
		        } else {
		        	setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		        	//table.setFont(new Font("Serif", Font.PLAIN, 13));
		        	cellRenderer.colAtMouse = -1;
		        }
		        
		        if (col == 0) {
		        	table.setEnabled(true);
		        } else {
		        	table.setEnabled(false);
		        }
			}
		});
		
		
		// 테이블 폰트 설정
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));

		// 컬럼명 폰트 설정
		JTableHeader tableHeader = table.getTableHeader();
		Font headerFont = new Font("맑은 고딕", Font.PLAIN, 14);
		tableHeader.setFont(headerFont);
		
		
		ImageIcon payBtnicon1 = new ImageIcon("images/mp3/결제하기버튼.png");
		Image payBtnimg1 = payBtnicon1.getImage();
		Image payBtn1 = payBtnimg1.getScaledInstance(300, 75, Image.SCALE_SMOOTH);
		ImageIcon payBtnicon2 = new ImageIcon("images/mp3/노란결제하기버튼.png");
		Image payBtnimg2 = payBtnicon2.getImage();
		Image payBtn2 = payBtnimg2.getScaledInstance(300, 75, Image.SCALE_SMOOTH);
		MyPageTabButton paymentButton = new MyPageTabButton("결제하기", new ImageIcon(payBtn1));
		paymentButton.setFont(new Font("굴림", Font.PLAIN, 0));
		paymentButton.setBounds(586, 675, 294, 75);
		paymentButton.setBorder(BorderFactory.createEmptyBorder());
		paymentButton.setRolloverIcon(new ImageIcon(payBtn2));
		add(paymentButton);
		paymentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				total_price = 0;
				for(int i = 0; i < checkedRows.size(); ++i) {
				total_price += Integer.parseInt(""+table2.getValueAt(i, 3)) ;				
				}
				
				DecimalFormat df = new DecimalFormat(",###");
				MainPanel.paymentPanel.totalPricelbl.setText(df.format(total_price) + "원");	
				
			}
		});

		DefaultTableModel model2 = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				if (column == 4) {
					return true;
				} else {
					return false;
				}
			}
		};
		
		JTable table2 = new JTable(); // 수정불가능한 테이블로 생성
		
		table2.setSelectionBackground(Color.white); //선택한셀 색 안변하게 하기
		
		
		
//		table.setPreferredScrollableViewportSize(new Dimension(700,600));
		
		//headings 설정
		
		model2.addColumn("강의명");
		model2.addColumn("강사명");
		model2.addColumn("수강 기간");
		model2.addColumn("수강료");
		model2.addColumn("쿠폰선택");
		model2.addColumn("결제금액");

		
		//obtain selected row
		paymentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				checkedRows = new ArrayList<>();
				
				
				
				
				for (int i = 0; i < table.getRowCount(); i++) {
					Boolean checked = Boolean.valueOf(table.getValueAt(i, 0).toString());
										
					if (checked) {
						checkedRows.add(i);
					} else {						
					
					}					
					
				}				
				rowSize = checkedRows.size();
				//System.out.println(checkedRows);
				int i = 0;
				for(int checkRow : checkedRows) {
					//System.out.println(checkRow);
					//System.out.println(data[checkRow][0]);
					model2.addRow(new Object[0]); 
					model2.setValueAt(data[checkRow][0], i, 0); // (data[row][column], 위치 row번째 행, 위치 column)
					model2.setValueAt(data[checkRow][1], i, 1);
					model2.setValueAt(data[checkRow][2], i, 2);
					model2.setValueAt(data[checkRow][3], i, 3);
					model2.setValueAt(data[checkRow][5], i, 4);
					model2.setValueAt(data[checkRow][6], i, 5);
					++i;					
				}
				table2.setModel(model2);
				
				table2.getColumnModel().getColumn(0).setMinWidth(280);
				table2.getColumnModel().getColumn(0).setMaxWidth(280);
				table2.getColumnModel().getColumn(1).setMinWidth(100);//셀 너비 조정
				table2.getColumnModel().getColumn(1).setMaxWidth(100);
				table2.getColumnModel().getColumn(2).setMinWidth(150);
				table2.getColumnModel().getColumn(2).setMaxWidth(150);
				
				table2.getColumnModel().getColumn(3).setMinWidth(70);
				table2.getColumnModel().getColumn(3).setMaxWidth(70);
				table2.getColumnModel().getColumn(4).setMinWidth(130);
				table2.getColumnModel().getColumn(4).setMaxWidth(130);
				table2.getColumnModel().getColumn(5).setMinWidth(80);
				table2.getColumnModel().getColumn(5).setMaxWidth(80);
				
			
								
				table2.setRowHeight(30); // 셀 높이 조정		
				table2.setCellSelectionEnabled(true); // 한셀만 선택가능
				table2.getTableHeader().setReorderingAllowed(false); //컬럼 헤더 고정 (이동 불가)
				table2.getTableHeader().setResizingAllowed(false); // 컬럼 크기 고정 (변경 불가)
				
				ListSelectionModel selectionModel = table2.getSelectionModel(); //한 행만 선택가능
				selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				// 테이블 폰트 설정
				table2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));

				// 컬럼명 폰트 설정
				JTableHeader tableHeader = table2.getTableHeader();
				Font headerFont = new Font("맑은 고딕", Font.PLAIN, 14);
				tableHeader.setFont(headerFont);
				
				String sql = "SELECT * FROM coupon_lists " + "WHERE member_id = ?" + " AND expiration_period > sysdate"
						+ " AND used_or_unused = '사용가능' ORDER BY coupon_name";

				try (Connection con = OjdbcConnection.getConnection();
						PreparedStatement pstmt = con.prepareStatement(sql);
						PreparedStatement pstmt1 = con.prepareStatement(sql);
				) {
					
					pstmt.setString(1, MainPanel.currUserId);
					pstmt1.setString(1, MainPanel.currUserId);
					
					ResultSet result = pstmt.executeQuery();
					ResultSet result1 = pstmt1.executeQuery();
					int j = 0;
					
					while (result.next()) {						
						++j;
					}
					
					couponArr = new String[j+1];
					discountRate = new Integer[j+1];
					
					int k = 1;
					couponArr[0]="선택안함";
					discountRate[0]=0;
					while (result1.next()) {
						couponArr[k] = result1.getString(4);
						discountRate[k]= result1.getInt(5);
						++k;
						
					}
//					for(String coupon :couponArr) {
//						arrList.add(coupon);
//					}
//					

				} catch (Exception e2) {					
					e2.printStackTrace();
				}
				/////////////////
				// 콤보박스 만들기//
				/////////////////
				
				table2.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseMoved(MouseEvent e) {
						
						rowrow = table2.rowAtPoint(e.getPoint());
						colcol = table2.columnAtPoint(e.getPoint());
						// System.out.println(rowrow + " /// " + colcol);
					}
				});

				newComboBox = new JComboBox<String>(couponArr);
				JComboBox comboBox = new JComboBox<String>(couponArr);
				ArrayList list = new ArrayList(Arrays.asList(couponArr));

				comboBox.addPopupMenuListener(new PopupMenuListener() {

					@Override
					public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
						// System.out.println("열림");
						// System.out.println(table2.getValueAt(rowrow, colcol)); //내가 집은 item 보기

						// 집은게 공백이거나 선택안함이면 아무동작안함
						if (rowrow > -1 && colcol > -1) {
							if ((("" + table2.getValueAt(rowrow, colcol)).equals("---쿠폰선택---"))
									|| (("" + table2.getValueAt(rowrow, colcol)).equals(""))
									|| (("" + table2.getValueAt(rowrow, colcol)).equals("null"))
									|| (("" + table2.getValueAt(rowrow, colcol)).equals("선택안함"))
									|| (list.indexOf(table2.getValueAt(rowrow, colcol)) == -1)) {
							} else {
								// 집은게 쿠폰이면 comboBox list에 넣는다
								// Item 다시 집어넣을때 순서섞이지 않게 집어넣기
								a = table2.getValueAt(rowrow, colcol);
								for (int i = 0; i < comboBox.getItemCount(); i++) {
									if (list.indexOf(comboBox.getItemAt(i)) != -1) {
										if (list.indexOf(comboBox.getItemAt(i)) > list.indexOf(a)) {
											comboBox.insertItemAt(a, i); // a는 집은 Item, i는 넣을 위치
											break; // 넣을위치 처음으로 찾은순간 반복문 빠져나온다
										}
									}
								}

							}
						} else {

						}

					}

					@Override
					public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
						//System.out.println("닫힘");
						//comboBox를 닫을때는 1.모든 item 지운다 2.초기상태로 재생성한다 3.현재 컬럼들에 있는 값들을 다 제거한다(공백칸과 선택안함은 무시)
						if (rowrow >= 0 && colcol == 4 && (list.indexOf(table2.getValueAt(rowrow, colcol)) > -1)) {
							//1.
							comboBox.removeAllItems();
							//2.
							for (int i = 0; i < newComboBox.getItemCount(); ++i) {
								comboBox.addItem(newComboBox.getItemAt(i));
							}
							//3
							for (int i = 0; i < checkedRows.size(); i++) {
								if ((("" + table2.getValueAt(rowrow, colcol)).equals("---쿠폰선택---"))
										||(("" + table2.getValueAt(i, 4)).equals(""))
										|| (("" + table2.getValueAt(i, 4)).equals("null"))
										|| ("" + table2.getValueAt(i, 4)).equals("선택안함")) {
								} else {
									comboBox.removeItem(table2.getValueAt(i, 4));

								}
							}
						}
						//////////////// 선택한 쿠폰에 따라 결제금액 계산하여 컬럼에 출력 /////////////
						int i = table2.getSelectedColumn();
						total_price = 0;
						if (i >= 0) {
							for (int j = 0; j < checkedRows.size(); ++j) {
							double price = (Integer.parseInt(""+table2.getValueAt(j, 3)))*((100-couponMap.get(""+table2.getValueAt(j, 4)))*0.01);
								model2.setValueAt(Math.round(price), j, 5);								
								total_price	+= Math.round(price);
							}							
						}
						DecimalFormat df = new DecimalFormat(",###");
						MainPanel.paymentPanel.totalPricelbl.setText(df.format(total_price) + "원");						
						
					}

					@Override
					public void popupMenuCanceled(PopupMenuEvent e) {

					}
				});

				// 테이블에서 하나의 column(열, 칸) 관리자 얻어오기
				TableColumn column = table2.getColumnModel().getColumn(4); // 표의 한 열을 담당하는 객체를 소환
				column.setCellEditor(new DefaultCellEditor(comboBox));

				table2.setFillsViewportHeight(true);
				MyPageMainPanel3.table2 = table2;
			}
		});

		table.setRowHeight(30); // 셀 높이 조정
		table.setCellSelectionEnabled(true); // 한셀만 선택가능
		table.getTableHeader().setReorderingAllowed(false); // 컬럼 헤더 고정 (이동 불가)
		table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 고정 (변경 불가)

		ListSelectionModel selectionModel = table.getSelectionModel(); // 한 행만 선택가능
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 800, 510);
		tablePanel.add(scrollPane);
		panel.add(tablePanel);
		setTable(table);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(80, 124, 800, 3);
		add(lblNewLabel);
		
		MainPanel.mypageMainPanel3 = this;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public static JTable getTable() {
		return table;
	}
}