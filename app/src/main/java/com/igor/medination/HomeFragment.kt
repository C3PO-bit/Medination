package com.igor.medination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment(R.layout.fragment_home) {

    private val mediaList = mutableListOf<Media>()
    private lateinit var adapter: MediaAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvEditorChoice = view.findViewById<RecyclerView>(R.id.rvEditorChoice)

        setupEditorChoiceAdapter(rvEditorChoice)
    }


    private fun setupEditorChoiceAdapter(recyclerView: RecyclerView) {
        adapter = MediaAdapter(mediaList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        mediaList.add(
            Media(
                R.drawable.rv_item_bg_blue,
                R.drawable.ic_overcome_anxiety,
                "Overcome Anxiety",
                "Meditations"
            )
        )
        mediaList.add(
            Media(
                R.drawable.rv_item_bg_green,
                R.drawable.ic_relax_before_bed,
                "Relax before bed",
                "Meditations"
            )
        )
        adapter.notifyDataSetChanged()
    }

    private fun setupMeditationsAdapter() {

    }

    private fun setupAffirmationsAdapter() {

    }

    private fun setupBinauralBeatsAdapter() {

    }


}
