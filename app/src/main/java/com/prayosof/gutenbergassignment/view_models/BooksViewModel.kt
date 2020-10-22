package com.prayosof.gutenbergassignment.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prayosof.gutenbergassignment.model.Books
import com.prayosof.gutenbergassignment.retrofit.MyApiEndpointInterface
import com.prayosof.gutenbergassignment.retrofit.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Yogesh Y. Nikam on 21/10/20.
 */

class BooksViewModel  : ViewModel() {

    var books_data: MutableLiveData<Books> = MutableLiveData()
    private val service = RetrofitClientInstance.getRetrofitInstance().create(MyApiEndpointInterface::class.java)



    fun init(topic: String, page: Int) {
//        if (books_data != null) {
//            return
//        }
        getBooksData(topic, page)
    }

    fun loadMoreData(topic: String, page: Int) {

    }

    fun getBooks(): MutableLiveData<Books>? {
        return this.books_data
    }
    init {
        //vehicleModel = ProjectRepository()
    }

    fun getBooksData(topic : String, page : Int): MutableLiveData<Books>? {
        val booksData: MutableLiveData<Books> = MutableLiveData<Books>()

        val call: Call<Books> = service.getBooksData(topic, page)
        call.enqueue(object : Callback<Books?> {
            override fun onResponse(call: Call<Books?>, response: Response<Books?>) {
                books_data.setValue(response.body())
            }

            override fun onFailure(call: Call<Books?>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return booksData;
    }
}