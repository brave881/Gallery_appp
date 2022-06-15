package com.example.gallery1.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery1.Constants
import com.example.gallery1.PhotoZoom
import com.example.gallery1.databinding.FragmentWallperBinding
import com.example.gallery1.model.AllPhotos
import com.example.gallery1.model.ResultPhoto
import com.example.gallery1.network.NetworkManager
import com.example.gallery1.utils.adapter.PhotosAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentWallpaper : Fragment() {


    private lateinit var adapter: PhotosAdapter
    private lateinit var rv: RecyclerView
    private val TAG = "FragmentWallpaper"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private var _binding: FragmentWallperBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecyclerView()
        adapter.setOytimClickListener {
            val intent = Intent(requireContext(), PhotoZoom::class.java)
            intent.putExtra("t1", it.urls.full)
            startActivity(intent)
        }

        val pos = arguments?.getInt(POSITION_ARG)

        pos?.let {
            when (pos) {
                0 -> {
                    NetworkManager.getInstance(requireContext())
                        .searchAll(1, 150, Constants.CLIENT_ID)
                        .enqueue(object : Callback<List<ResultPhoto>> {
                            override fun onResponse(
                                call: Call<List<ResultPhoto>>,
                                response: Response<List<ResultPhoto>>
                            ) {
                                if (response.isSuccessful) {
                                    adapter.submitItem(response.body() ?: emptyList())
                                    rv.adapter = adapter
                                    Log.d(TAG, "onResponse: ${response.body()}")
                                    return
                                } else Log.d(TAG, "onResponse: ${response.body()}")
                            }

                            override fun onFailure(call: Call<List<ResultPhoto>>, t: Throwable) {
                                Log.d(TAG, "onResponse: ${t.localizedMessage}")
                            }
                        })
                }
                1 -> {
                    NetworkManager.getInstance(requireContext())
                        .getPhotosLatest("images", 1, 30, "latest", Constants.CLIENT_ID)
                        .enqueue(object : Callback<AllPhotos> {
                            override fun onResponse(
                                call: Call<AllPhotos>,
                                response: Response<AllPhotos>
                            ) {
                                if (response.isSuccessful) {
                                    adapter.submitItem(response.body()?.results ?: emptyList())
                                    rv.adapter = adapter
                                    Log.d(TAG, "onResponse: ${response.body()?.results}")
                                    return
                                } else Log.d(TAG, "onResponse: ${response.body()}")
                            }

                            override fun onFailure(call: Call<AllPhotos>, t: Throwable) {
                                Log.d(TAG, "onResponse: ${t.localizedMessage}")
                            }
                        })
                }
                2 -> {
                    NetworkManager.getInstance(requireContext())
                        .getPhotos("technology", 1, 30, Constants.CLIENT_ID)
                        .enqueue(object : Callback<AllPhotos> {
                            override fun onResponse(
                                call: Call<AllPhotos>,
                                response: Response<AllPhotos>
                            ) {
                                if (response.isSuccessful) {
                                    adapter.submitItem(response.body()?.results ?: emptyList())
                                    rv.adapter = adapter
                                    Log.d(TAG, "onResponse: ${response.body()?.results}")
                                    return
                                } else Log.d(TAG, "onResponse: ${response.body()}")
                            }

                            override fun onFailure(call: Call<AllPhotos>, t: Throwable) {
                                Log.d(TAG, "onResponse: ${t.localizedMessage}")
                            }
                        })
                }
                3 -> {
                    NetworkManager.getInstance(requireContext())
                        .getPhotos("nature", 1, 30, Constants.CLIENT_ID)
                        .enqueue(object : Callback<AllPhotos> {
                            override fun onResponse(
                                call: Call<AllPhotos>,
                                response: Response<AllPhotos>
                            ) {
                                if (response.isSuccessful) {
                                    adapter.submitItem(response.body()?.results ?: emptyList())
                                    rv.adapter = adapter
                                    Log.d(TAG, "onResponse: ${response.body()?.results}")
                                    return
                                } else Log.d(TAG, "onResponse: ${response.body()}")
                            }

                            override fun onFailure(call: Call<AllPhotos>, t: Throwable) {
                                Log.d(TAG, "onResponse: ${t.localizedMessage}")
                            }
                        })
                }
                4 -> {
                    NetworkManager.getInstance(requireContext())
                        .getPhotos("animals", 1, 30, Constants.CLIENT_ID)
                        .enqueue(object : Callback<AllPhotos> {
                            override fun onResponse(
                                call: Call<AllPhotos>,
                                response: Response<AllPhotos>
                            ) {
                                if (response.isSuccessful) {
                                    adapter.submitItem(response.body()?.results ?: emptyList())
                                    rv.adapter = adapter
                                    Log.d(TAG, "onResponse: ${response.body()?.results}")
                                    return
                                } else Log.d(TAG, "onResponse: ${response.body()}")
                            }

                            override fun onFailure(call: Call<AllPhotos>, t: Throwable) {
                                Log.d(TAG, "onResponse: ${t.localizedMessage}")
                            }
                        })
                }
                else -> {
                    Log.d(TAG, "onViewCreated: Error")
                }
            }

            rv.adapter = adapter

        }


    }

    //           "ALL",
//            "NEW",
//            "TECHNOLOGY",
//            "NATURE",
//            "ANIMALS")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWallperBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        var POSITION_ARG = "position_arg"

        @JvmStatic
        fun newInstance(position: Int) = FragmentWallpaper().apply {
            arguments = Bundle().apply {
                putInt(POSITION_ARG, position)
            }
        }
    }


/*
    private fun getImages(s: String): List<ResultPhoto>? {
        var ad: List<ResultPhoto>? = null
        val pos = arguments?.getInt(POSITION_ARG)

        pos?.let {
            when (pos) {
                0 -> {
                    NetworkManager.getInstance(requireContext()).getPhotos(s, 1, 30, Constants.CLIENT_ID)
                        .enqueue(object : Callback<AllPhotos> {
                            override fun onResponse(
                                call: Call<AllPhotos>,
                                response: Response<AllPhotos>
                            ) {
                                if (response.isSuccessful) {
                                    ad = response.body()?.results ?: emptyList()
                                    Log.d(TAG, "onResponse: ${response.body()?.results}")
                                    return
                                } else Log.d(TAG, "onResponse: ${response.body()}")
                            }

                            override fun onFailure(call: Call<AllPhotos>, t: Throwable) {
                                Log.d(TAG, "onResponse: ${t.localizedMessage}")
                            }
                        })
                }
                1 -> {
                    adapter.submitItem(getImages("new") ?: emptyList())
                    vp.adapter = adapter
                }
                2 -> {
                    adapter.submitItem(getImages("technology")!!)
                    vp.adapter = adapter
                }
                3 -> {
                    adapter.submitItem(getImages("nature")!!)
                    vp.adapter = adapter
                }
                4 -> {
                    adapter.submitItem(getImages("animals")!!)
                    vp.adapter = adapter
                }
                else -> {
                    Log.d(TAG, "onViewCreated: Error")
                }
            }

            vp.adapter = adapter

        }



        */
/*           NetworkManager.getInstance(requireContext()).searchAll(Constants.CLIENT_ID)
                       .enqueue(object : Callback<List<ResultPhoto>> {
                           override fun onResponse(
                               call: Call<List<ResultPhoto>>,
                               response: Response<List<ResultPhoto>>
                           ) {
                               if (response.isSuccessful) {
                                   ad = response.body()!!
                                   Log.d(TAG, "onResponse: ${response.body()}")
                               } else Log.d(TAG, "onResponse: ${response.body()}")
                           }

                           override fun onFailure(call: Call<List<ResultPhoto>>, t: Throwable) {
                               Log.d(TAG, "onResponse: ${t.localizedMessage}")
                           }
                       })


                   NetworkManager.getInstance(requireContext()).getPhotosLatest(s, 1, 30, "latest", Constants.CLIENT_ID)
                       .enqueue(object : Callback<List<ResultPhoto>> {
                           override fun onResponse(
                               call: Call<List<ResultPhoto>>,
                               response: Response<List<ResultPhoto>>
                           ) {
                               if (response.isSuccessful) {
                                   ad = response.body()!!
                                   Log.d(TAG, "onResponse: ${response.body()}")
                               } else Log.d(TAG, "onResponse: ${response.body()}")
                           }

                           override fun onFailure(call: Call<List<ResultPhoto>>, t: Throwable) {
                               Log.d(TAG, "onResponse: ${t.localizedMessage}")
                           }
                       })
       *//*


        return ad
    }
*/

    private fun initRecyclerView() {
        rv = binding.wallpaper
        rv.layoutManager = GridLayoutManager(requireActivity(), 3)
        adapter = PhotosAdapter()

    }
}