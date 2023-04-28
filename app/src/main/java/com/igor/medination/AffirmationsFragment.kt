package com.igor.medination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class AffirmationsFragment : Fragment(R.layout.fragment_affirmations) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvAffirmations = view.findViewById<RecyclerView>(R.id.rvAffirmationsCategory)
        setupAdapter(rvAffirmations)
    }

    private fun setupAdapter(recyclerView: RecyclerView): CategoryItemsAdapter {
        val items = mutableListOf<CategoryItems>()
        items.add(
            CategoryItems(
                "I am worthy",
                "This affirmation emphasizes that you are deserving of love, respect, and success, regardless of your past mistakes",
                "50 sec"
            )
        )
        items.add(
            CategoryItems(
                "I am capable",
                "This affirmation focuses on your ability to achieve your goals and overcome any challenges that come your way",
                "3 min"
            )
        )
        items.add(
            CategoryItems(
                "I am confident",
                "This affirmation helps you build your self-esteem and trust in your abilities.",
                "2 min"
            )
        )
        items.add(
            CategoryItems(
                "I am at peace",
                "This affirmation emphasizes the importance of finding inner peace and calm",
                "4 min"
            )
        )
        val adapter = CategoryItemsAdapter(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        adapter.notifyDataSetChanged()
        return adapter
    }
}
