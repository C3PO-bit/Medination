package com.igor.medination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MeditationsFragment : Fragment(R.layout.fragment_meditations) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvMeditations = view.findViewById<RecyclerView>(R.id.rvMeditationsCategory)

        setupAdapter(rvMeditations)

    }

    private fun setupAdapter(recyclerView: RecyclerView): CategoryItemsAdapter {
        val items = mutableListOf<CategoryItems>()
        items.add(
            CategoryItems(
                "Overcome Social Anxiety",
                " Let go of anxious thoughts and emotions and find peace in the present moment.",
                "5 min"
            )
        )
        items.add(
            CategoryItems(
                "Relaxing Before Bedtime",
                "Prepare your mind and body for a peaceful night's rest with this relaxation practice",
                "7 min"
            )
        )
        items.add(
            CategoryItems(
                "Loving Yourself",
                "Release negative thoughts and emotions towards your body and cultivate a sense of love and gratitude.",
                "10 min"
            )
        )
        items.add(
            CategoryItems(
                "Focused Mind",
                "Release negative thoughts and emotions towards your body and cultivate a sense of love and gratitude.",
                "10 min"
            )
        )
        items.add(
            CategoryItems(
                "Forgiveness and Release",
                " Let go of past grievances and cultivate forgiveness and compassion towards yourself and others",
                "6 min"
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
