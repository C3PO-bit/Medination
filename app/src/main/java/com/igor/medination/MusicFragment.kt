package com.igor.medination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MusicFragment : Fragment(R.layout.fragment_music) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvMusicCategory = view.findViewById<RecyclerView>(R.id.rvMusicCategory)
        setupAdapter(rvMusicCategory)
    }

    private fun setupAdapter(recyclerView: RecyclerView): CategoryItemsAdapter {
        val items = mutableListOf<CategoryItems>()
        items.add(
            CategoryItems(
                "Deep Relaxation",
                "This binaural beat track is designed to enhance your cognitive function and improve your ability to focus and concentrate.",
                "10 min"
            )
        )
        items.add(
            CategoryItems(
                "Power Nap",
                "This binaural beat track is designed to help you take a quick power nap and wake up feeling refreshed and rejuvenated.",
                "7 min"
            )
        )
        items.add(
            CategoryItems(
                "Anxiety Relief",
                "This binaural beat track is designed to help alleviate symptoms of anxiety and promote a sense of calm and relaxation.",
                "9 min"
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
                "Mood Booster",
                "This binaural beat track is designed to help lift your mood and promote feelings of positivity and happiness",
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
