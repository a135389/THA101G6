package course.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
    public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer courseID;
        private String courseName;
        private String courseIntroduce;
        private Integer courseMax;
        private Integer courseMin;
        private Integer coursePerson;
        private Integer coursePrice;
        private byte[] coursePhoto;
        private String level;
        private Integer coachID;
        private String skill;
        private Integer pointID;
        private String courseDate;
        private String startDate;
        private String endDate;
        private String courseStatus;

        // Constructors
        public Course() {
        }

		public Course(Integer courseID, String courseName, String courseIntroduce, Integer courseMax, Integer courseMin,
				Integer coursePerson, Integer coursePrice, byte[] coursePhoto, String level, Integer coachID,
				String skill, Integer pointID, String courseDate, String startDate, String endDate,
				String courseStatus) {
			super();
			this.courseID = courseID;
			this.courseName = courseName;
			this.courseIntroduce = courseIntroduce;
			this.courseMax = courseMax;
			this.courseMin = courseMin;
			this.coursePerson = coursePerson;
			this.coursePrice = coursePrice;
			this.coursePhoto = coursePhoto;
			this.level = level;
			this.coachID = coachID;
			this.skill = skill;
			this.pointID = pointID;
			this.courseDate = courseDate;
			this.startDate = startDate;
			this.endDate = endDate;
			this.courseStatus = courseStatus;
		}

		public Integer getCourseID() {
			return courseID;
		}

		public void setCourseID(Integer courseID) {
			this.courseID = courseID;
		}

		public String getCourseName() {
			return courseName;
		}

		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}

		public String getCourseIntroduce() {
			return courseIntroduce;
		}

		public void setCourseIntroduce(String courseIntroduce) {
			this.courseIntroduce = courseIntroduce;
		}

		public Integer getCourseMax() {
			return courseMax;
		}

		public void setCourseMax(Integer courseMax) {
			this.courseMax = courseMax;
		}

		public Integer getCourseMin() {
			return courseMin;
		}

		public void setCourseMin(Integer courseMin) {
			this.courseMin = courseMin;
		}

		public Integer getCoursePerson() {
			return coursePerson;
		}

		public void setCoursePerson(Integer coursePerson) {
			this.coursePerson = coursePerson;
		}

		public Integer getCoursePrice() {
			return coursePrice;
		}

		public void setCoursePrice(Integer coursePrice) {
			this.coursePrice = coursePrice;
		}

		public byte[] getCoursePhoto() {
			return coursePhoto;
		}

		public void setCoursePhoto(byte[] coursePhoto) {
			this.coursePhoto = coursePhoto;
		}

		public String getLevel() {
			return level;
		}

		public void setLevel(String level) {
			this.level = level;
		}

		public Integer getCoachID() {
			return coachID;
		}

		public void setCoachID(Integer coachID) {
			this.coachID = coachID;
		}

		public String getSkill() {
			return skill;
		}

		public void setSkill(String skill) {
			this.skill = skill;
		}

		public Integer getPointID() {
			return pointID;
		}

		public void setPointID(Integer pointID) {
			this.pointID = pointID;
		}

		public String getCourseDate() {
			return courseDate;
		}

		public void setCourseDate(String courseDate) {
			this.courseDate = courseDate;
		}

		public String getStartDate() {
			return startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}

		public String getEndDate() {
			return endDate;
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}

		public String getCourseStatus() {
			return courseStatus;
		}

		public void setCourseStatus(String courseStatus) {
			this.courseStatus = courseStatus;
		}



    }


