package com.example.fromtouzdemo.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.fromtouzdemo.R
import com.example.fromtouzdemo.data.local.Body
import com.example.fromtouzdemo.data.models.BodyData
import com.example.fromtouzdemo.data.models.RequestData
import com.example.fromtouzdemo.databinding.FragmentMainBinding
import com.example.fromtouzdemo.presentation.history.HistoryViewModel
import com.example.fromtouzdemo.presentation.translate.TranslateViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding
    private var langFrom = "uz"
    private var langTo = "kaa"
    private var translate = true
    private val translateViewModel: TranslateViewModel by viewModel()
    private val historyViewModel: HistoryViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        binding.tvTitle.text = "Translate"

        initObservers()

        initListeners()

        binding.tvTitle.setOnClickListener {
            getAll()
        }

    }

    private fun initObservers() {
        translateViewModel.liveData.observe(requireActivity()) {
            binding.etOutput.setText(it)
        }
    }

    private fun initListeners() {
        binding.btnTranslate.setOnClickListener {
            if (translate) {
                translate()
            } else transliterate()
        }

        binding.tvTranslate.setOnClickListener {

            langFrom = "uz"
            langTo = "kaa"
            binding.tvLangFrom.text = "Uzbek"
            binding.tvLangTo.text = "Karakalpak"
            binding.tvTitle.text = "Translate"

        }

        binding.tvTransliterate.setOnClickListener {

            langFrom = "kaa_latin"
            langTo = "kaa_cyrillic"
            binding.tvLangFrom.text = "Latin"
            binding.tvLangTo.text = "Kirill"
            binding.tvTitle.text = "Kirill-Latin"

        }

        binding.btnChange.setOnClickListener {

            langFrom = langTo.apply {
                langTo = langFrom
            }

            binding.tvLangFrom.text = binding.tvLangTo.text.apply {
                binding.tvLangTo.text = binding.tvLangFrom.text
            }

            binding.etInput.text = binding.etOutput.text.apply {
                binding.etOutput.text = binding.etInput.text
            }

        }
    }

    private fun translate() {
        val text = binding.etInput.text.toString()
        if (text.isNotEmpty()) {
            val requestData = RequestData(
                BodyData(
                    langFrom = langFrom,
                    langTo = langTo,
                    text = text
                )
            )
            val body = Body(
                id = 0,
                langFrom = langFrom,
                langTo = langTo,
                text = text
            )
            MainScope().launch {
                translateViewModel.translate(requestData)

                try {
                    historyViewModel.addBody(body)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

        }
    }

    private fun transliterate() {
        val text = binding.etOutput.text.toString()
        if (text.isNotEmpty()) {
            val requestData = RequestData(
                BodyData(
                    langFrom = langFrom,
                    langTo = langTo,
                    text = text
                )
            )
            val body = Body(
                id = 0,
                langFrom = langFrom,
                langTo = langTo,
                text = text
            )
            lifecycleScope.launch {
                translateViewModel.transliterate(requestData)

                historyViewModel.addBody(body)
            }
        }
    }

    private fun getAll() {
        historyViewModel.bodyLiveData.observe(requireActivity()) { it ->
            it.forEach {
                Log.d("TTTT", it.text)
            }
        }

        lifecycleScope.launch {
            historyViewModel.getAllBodies()
        }
    }
}