package com.kiran.student.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kiran.student.R
import com.kiran.student.api.ServiceBuilder
import com.kiran.student.entity.Student
import de.hdodenhof.circleimageview.CircleImageView


class StudentAdapter(
    val lstStudents: MutableList<Student>,
    val context: Context
): RecyclerView.Adapter<StudentAdapter.DetailViewHolder>(){
    class DetailViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgProfile: CircleImageView
        val tvName: TextView
        val tvAddress: TextView
        val tvSalary: TextView
        val tvAge: TextView
        val delete: ImageView

        init {
            imgProfile=view.findViewById(R.id.imgProfile)
            tvName=view.findViewById(R.id.tvName)
            tvAddress=view.findViewById(R.id.tvAddress)
            tvSalary=view.findViewById(R.id.tvSalary)
            tvAge=view.findViewById(R.id.tvGender)
            delete=view.findViewById(R.id.delete)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.view_layout, parent, false)
        return DetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val detail=lstStudents[position]
        holder.tvName.text=detail.fullname
        holder.tvAddress.text=detail.address
        holder.tvSalary.text=detail.gender
        holder.tvAge.text=detail.age.toString()
//        load iamge with glide library
        val imagePath = ServiceBuilder.loadImagePath() + detail.photo
        if (!detail.photo.equals("no-photo.jpg")) {
            Glide.with(context)
                .load(imagePath)
                .fitCenter()
                .into(holder.imgProfile)
        }

        holder.imgProfile.setOnClickListener {
            Toast.makeText(context,"${detail.fullname} clicked", Toast.LENGTH_LONG).show()

        }



    }

    override fun getItemCount(): Int {
        return lstStudents.size
    }
}
