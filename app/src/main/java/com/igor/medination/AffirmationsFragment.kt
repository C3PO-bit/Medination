package com.igor.medination

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray



class AffirmationsFragment : Fragment(R.layout.fragment_affirmations) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvAffirmations = view.findViewById<RecyclerView>(R.id.rvAffirmationsCategory)
        setupAdapter(rvAffirmations)
    }

    private fun setupAdapter(recyclerView: RecyclerView): CategoryItemsAdapter {


        val jsonString = resources.openRawResource(R.raw.affirmations).bufferedReader().use {
            it.readText()
        }

        val jsonArray = JSONArray(jsonString)

        val items = mutableListOf<CategoryItems>()

        for (i in 0 until  jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val title = jsonObject.getString("title")
            val description = jsonObject.getString("description")
            val duration = jsonObject.getString("duration")

            val item = CategoryItems(title,description,duration)
            items.add(item)
        }

        val listener = object : CategoryItemsAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(requireContext(), MediaPlayerActivity::class.java)
                startActivity(intent)
            }
        }

        val adapter = CategoryItemsAdapter(items, listener)
        recyclerView.adapter = adapter

        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        adapter.notifyDataSetChanged()
        return adapter


//        items.add(
//            CategoryItems(
//                "I am worthy",
//                "This affirmation emphasizes that you are deserving of love, respect, and success, regardless of your past mistakes",
//                "50 sec"
//            )
//        )
//        items.add(
//            CategoryItems(
//                "I am capable",
//                "This affirmation focuses on your ability to achieve your goals and overcome any challenges that come your way",
//                "3 min"
//            )
//        )
//        items.add(
//            CategoryItems(
//                "I am confident",
//                "This affirmation helps you build your self-esteem and trust in your abilities.",
//                "2 min"
//            )
//        )
//        items.add(
//            CategoryItems(
//                "I am at peace",
//                "This affirmation emphasizes the importance of finding inner peace and calm",
//                "4 min"
//            )
//        )

    }


}
