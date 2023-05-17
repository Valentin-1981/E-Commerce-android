package com.testproject.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.testproject.e_commerce.adapter.CategoryAdapter;
import com.testproject.e_commerce.adapter.CourseAdapter;
import com.testproject.e_commerce.model.Category;
import com.testproject.e_commerce.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;

    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCoursesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Игры"));
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Прочее"));

        setCategoryRecycler(categoryList);

        courseList.add(new Course(1, "java_2", "Профессия Java\nразработчик", "1 января", "начальный", "#424345", "Test", 3));
        courseList.add(new Course(2, "python_1", "Профессия Python\nразработчик","10 января", "начальный", "#9FA52D", "Test", 3));
        courseList.add(new Course(3, "cpp_2", "Профессия C++\nразработчик","15 июня", "начальный", "#E44C30", "Test", 1));
        courseList.add(new Course(4, "unity_1", "Профессия Unity\nразработчик","02 июля", "начальный", "#4476D6", "Test", 2));
        courseList.add(new Course(5, "csharp_1", "Профессия C#\nразработчик","10 июня", "начальный", "#0D0F29", "Test", 2));
        courseList.add(new Course(6, "full_stack_1", "Профессия Full Stack\nразработчик","14 июня", "начальный", "#A2CAE3", "Test", 1));
//        courseList.add(new Category(3, "Языки"));
//        courseList.add(new Category(4, "Прочее"));

        fullCoursesList.addAll(courseList);

        setCourseRecycler(courseList);
    }

    public void openShoppingCart(View view){
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
    }

    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);

    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    public static void showCoursesByCategory(int category){
        courseList.clear();
        courseList.addAll(fullCoursesList);

        List<Course> filterCourses = new ArrayList<>();

        for (Course c : courseList) {
            if(c.getCategory() == category) {
                filterCourses.add(c);
            }
        }

        courseList.clear();
        courseList.addAll(filterCourses);

        courseAdapter.notifyDataSetChanged();
    }
}