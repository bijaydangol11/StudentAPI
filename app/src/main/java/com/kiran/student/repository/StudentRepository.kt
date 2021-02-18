package com.kiran.student.repository

import com.kiran.student.api.MyApiRequest
import com.kiran.student.api.ServiceBuilder
import com.kiran.student.api.StudentApi
import com.kiran.student.entity.Student
import com.kiran.student.response.AddStudentResponse
import com.kiran.student.response.StudentResponse


class StudentRepository:MyApiRequest() {
    private val studentApi=ServiceBuilder.buildService(StudentApi::class.java)

    suspend fun insertStudent(student:Student):AddStudentResponse{
        return apiRequest {
            studentApi.insertStudent(ServiceBuilder.token!!,student)
        }
    }

    suspend fun getAllStudent(): StudentResponse {
        return apiRequest {
            studentApi.getAllStudents(ServiceBuilder.token!!)
        }

    }

}