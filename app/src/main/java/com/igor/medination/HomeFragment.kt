package com.igor.medination

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvEditorChoice = view.findViewById<RecyclerView>(R.id.rvEditorChoice)
        val rvMeditations = view.findViewById<RecyclerView>(R.id.rvMeditations)
        val rvAffirmations = view.findViewById<RecyclerView>(R.id.rvAffirmations)
        val rvBinauralBeats = view.findViewById<RecyclerView>(R.id.rvBinauralBeats)

        setupEditorChoiceAdapter(rvEditorChoice)
        setupMeditationsAdapter(rvMeditations)
        setupAffirmationsAdapter(rvAffirmations)
        setupBinauralBeatsAdapter(rvBinauralBeats)
    }


    private fun setupEditorChoiceAdapter(recyclerView: RecyclerView): MediaAdapter {
        val mediaList = listOf(
            Media(
                R.drawable.rv_item_bg_blue,
                R.drawable.ic_overcome_anxiety,
                "Overcome Anxiety",
                "MEDITATIONS"
            ),
            Media(
                R.drawable.rv_item_bg_purple,
                R.drawable.ic_choose_positive,
                "I choose positivity",
                "AFFIRMATIONS"
            )
        )

        val adapter = MediaAdapter(mediaList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        return adapter
    }

    private fun setupMeditationsAdapter(recyclerView: RecyclerView): MediaAdapter {
        val mediaList = listOf(
            Media(
                R.drawable.rv_item_bg_salmon,
                R.drawable.ic_embrace_uncertain,
                "Embracing Uncertain",
                "MEDITATIONS"
            ), Media(
                R.drawable.rv_item_bg_green,
                R.drawable.ic_relax_before_bed,
                "Before Bedtime",
                "MEDITATIONS"
            )
        )

        val adapter = MediaAdapter(mediaList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        return adapter
    }


    private fun setupAffirmationsAdapter(recyclerView: RecyclerView): MediaAdapter {
        val mediaList = listOf(
            Media(
                R.drawable.rv_item_bg_purple,
                R.drawable.ic_at_peace,
                "I am at peace",
                "AFFIRMATIONS"
            ), Media(
                R.drawable.rv_item_bg_blue,
                R.drawable.ic_confidence,
                "I am confident",
                "AFFIRMATIONS"
            )
        )

        val adapter = MediaAdapter(mediaList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        return adapter
    }

    private fun setupBinauralBeatsAdapter(recyclerView: RecyclerView): MediaAdapter {
        val mediaList = listOf(
            Media(
                R.drawable.rv_item_bg_yellow,
                R.drawable.ic_deep_sleep,
                "Power Nap",
                "BINAURAL BEATS"
            ),
            Media(
                R.drawable.rv_item_bg_green,
                R.drawable.ic_stress_relief,
                "Anxiety Relief",
                "BINAURAL BEATS"
            )
        )

        val adapter = MediaAdapter(mediaList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        return adapter
    }


}
