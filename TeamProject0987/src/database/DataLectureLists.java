package database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataLectureLists {
	private static ArrayList<String> lectureNameArr = new ArrayList<>();
	private static ArrayList<String> teacherNameArr = new ArrayList<>();
	private static ArrayList<String> categoryArr = new ArrayList<>();
	private static ArrayList<String> startDateArr = new ArrayList<>();
	private static ArrayList<String> endDateArr = new ArrayList<>();
	private static ArrayList<String> lectureInfoArr = new ArrayList<>();
	private static ArrayList<String> couponCodeArr = new ArrayList<>();
	
	public DataLectureLists() {
//		setLectureNameArr();
//		setTeacherNameArr();
//		setCategoryArr();
//		setStartDateArr();
//		setEndDateArr();
//		setLectureInfoArr();
		setCouponCodeArr();
	}
	
	public void setLectureNameArr() {
		try (BufferedReader in = new BufferedReader(new FileReader("dataFile/LectureName"));) 
		{
			String line;
			while ((line = in.readLine()) != null) {
				lectureNameArr.add(line);
			}
			System.out.println("lectureNameArr created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setTeacherNameArr() {
		try (BufferedReader in = new BufferedReader(new FileReader("dataFile/TeacherName"));) 
		{
			String line;
			while ((line = in.readLine()) != null) {
				teacherNameArr.add(line);
			}
			System.out.println("teacherNameArr created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setCategoryArr() {
		try (BufferedReader in = new BufferedReader(new FileReader("dataFile/Category"));) 
		{
			String line;
			while ((line = in.readLine()) != null) {
				categoryArr.add(line);
			}
			System.out.println("categoryArr created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setStartDateArr() {
		try (BufferedReader in = new BufferedReader(new FileReader("dataFile/LectureStartDate"));) 
		{
			String line;
			while ((line = in.readLine()) != null) {
				startDateArr.add(line);
			}
			System.out.println("Lecture Start Date Array is created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setEndDateArr() {
		try (BufferedReader in = new BufferedReader(new FileReader("dataFile/LectureEndDate"));) 
		{
			String line;
			while ((line = in.readLine()) != null) {
				endDateArr.add(line);
			}
			System.out.println("Lecture End Date Array is created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setLectureInfoArr() {
		try (BufferedReader in = new BufferedReader(new FileReader("dataFile/LectureInfo"));) 
		{
			String line;
			while ((line = in.readLine()) != null) {
				lectureInfoArr.add(line);
			}
			System.out.println("LectureInfoArray is created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setCouponCodeArr() {
		try (BufferedReader in = new BufferedReader(new FileReader("dataFile/CouponCode"));) 
		{
			String line;
			while ((line = in.readLine()) != null) {
				couponCodeArr.add(line);
			}
			System.out.println("CouponCode Array is created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getLectureNameArr() {
		return lectureNameArr;
	}
	
	public ArrayList<String> getTeacherNameArr() {
		return teacherNameArr;
	}
	
	public ArrayList<String> getCategoryArr() {
		return categoryArr;
	}
	
	public ArrayList<String> getStartDateArr() {
		return startDateArr;
	}
	
	public ArrayList<String> getEndDateArr() {
		return endDateArr;
	}
	
	public ArrayList<String> getLectureInfoArr() {
		return lectureInfoArr;
	}
	
	public ArrayList<String> getCouponCodeArr() {
		return couponCodeArr;
	}
}
