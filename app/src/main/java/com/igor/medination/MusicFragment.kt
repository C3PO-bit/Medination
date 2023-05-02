package com.igor.medination

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray


class MusicFragment : Fragment(R.layout.fragment_music) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvMusicCategory = view.findViewById<RecyclerView>(R.id.rvMusicCategory)
        setupAdapter(rvMusicCategory)
    }

    private fun setupAdapter(recyclerView: RecyclerView): CategoryItemsAdapter {

        val jsonString = resources.openRawResource(R.raw.binaural_beats).bufferedReader().use  {
            it.readText()
        }
        val jsonArray = JSONArray(jsonString)
        val items = mutableListOf<CategoryItems>()
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val title = jsonObject.getString("title")
            val description = jsonObject.getString("description")
            val duration = jsonObject.getString("duration")

            val item = CategoryItems(title,description,duration)
            items.add(item)
        }

        val listener = object : CategoryItemsAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(requireContext(),MediaPlayerActivity::class.java)
                startActivity(intent)
            }
        }
        val adapter  = CategoryItemsAdapter(items,listener)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


        return adapter

    }

}
