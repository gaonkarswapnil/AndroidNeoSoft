package com.example.finalapplication.jsondata.displayjson

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalapplication.R
import com.example.finalapplication.databinding.ActivitySimpleJsonfetchBinding
import org.json.JSONObject

class SimpleJSONFetchActivity : AppCompatActivity() {
    lateinit var binding: ActivitySimpleJsonfetchBinding
    private lateinit var studentList: LinearLayout
    private val schoolList: MutableList<School> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySimpleJsonfetchBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        try {
            val obj = JSONObject(getJSONFromAssets()!!)
            val school = obj.getJSONObject("school")
            val schoolName = school.getString("name")

            val location = school.getString("location")

            val studentList: MutableList<Student> = mutableListOf()

            val students = school.getJSONArray("students")
            for (i in 0 until students.length()) {
                val student = students.getJSONObject(i)
                val studentId = student.getInt("id")
                val studentName = student.getString("name")
                val studentGrade = student.getString("grade")

                val subjectList: MutableList<Subject> = mutableListOf();
                val subjects = student.getJSONArray("subjects")
                for (j in 0 until subjects.length()) {
                    val subject = subjects.getJSONObject(j)

                    val subjectName = subject.getString("name")

                    val subjectMarks = subject.getJSONObject("marks")
                    val marks = Marks(
                        midterm = subjectMarks.getInt("midterm"),
                        finalExam = subjectMarks . getInt ("final")
                    )

                    subjectList.add(Subject(subjectName, marks))

                }
                studentList.add(Student(studentId, studentName, studentGrade, subjectList))
            }

            val teacherList: MutableList<Teacher> = mutableListOf()
            val teachers = school.getJSONArray("teachers")
            for (i in 0 until teachers.length()){
                val teacher = teachers.getJSONObject(i)

                val teacherName = teacher.getString("name")
                val teacherSubject = teacher.getString("subject")
                val teacherExperience = teacher.getInt("experience")

                val teacherContact = teacher.getJSONObject("contact")

                val contact = Contact(
                    email = teacherContact.getString("email"),
                    phone = teacherContact.getString("phone")
                )

                teacherList.add(Teacher(teacherName, teacherSubject, teacherExperience, contact))
            }

            val classesList: MutableList<Classes> = mutableListOf()
            val classes = school.getJSONArray("classes")
            for(i in 0 until classes.length()){
                val _class = classes.getJSONObject(i);

                val className = _class.getString("name")
                val classTeacher = _class.getString("teacher")

                val classScheduleList: MutableList<Schedule> = mutableListOf()
                val classSchedule = _class.getJSONArray("schedule")
                for (j in 0 until classSchedule.length()){
                    val schedule = classSchedule.getJSONObject(j)

                    val day = schedule.getString("day")
                    val time = schedule.getString("time")

                    classScheduleList.add(Schedule(day, time))
                }

                classesList.add(Classes(className, classTeacher, classScheduleList))

            }

            val extraCurricularActivitiesList: MutableList<ExtraCurricularActivities> = mutableListOf()
            val extraCurricularActivities = school.getJSONArray("extraurricularActivities")
            for (i in 0 until extraCurricularActivities.length()){
                val extra = extraCurricularActivities.getJSONObject(i)
                val name = extra.getString("name")
                val coach = extra.getString("coach")

                val scheduleList: MutableList<Schedule> = mutableListOf()
                val schedule = extra.getJSONArray("schedule")
                for (j in 0 until schedule.length()){
                    val sch = schedule.getJSONObject(i)

                    val day = sch.getString("day")
                    val time = sch.getString("time")

                    scheduleList.add(Schedule(day, time))
                }
                extraCurricularActivitiesList.add(ExtraCurricularActivities(name, coach, scheduleList))
            }



//            schoolList.add(School(schoolName, location, studentList, teacherList, classesList, extraCurricularActivitiesList))
            binding.tvSchoolName.text = schoolName
            binding.tvSchoolLocation.text = location

            displayDetails(studentList)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getJSONFromAssets(): String? {
        var json: String? = null;
        val charSet = Charsets.UTF_8
        try {
            val schoolJSONFile = assets.open("school.json")
            val size = schoolJSONFile.available()
            val buffer = ByteArray(size)
            json = String(buffer, charSet)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return json;
    }

    fun displayDetails(students: List<Student>){


        for (student in students){
            val textView = TextView(this)
            textView.text = "${student.studentId}-${student.studentName}-${student.studentGrade}-${student.subjects}"

            studentList.addView(textView)
        }
    }
}