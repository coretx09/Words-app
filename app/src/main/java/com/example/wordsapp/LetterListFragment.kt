package com.example.wordsapp

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.FragmentLetterListBinding


class LetterListFragment : Fragment() {

    // liaisons des views (binding view)
    /* reference initialise a null
     Parce que vous ne pouvez pas gonfler la mise en page tant qu'elle onCreateView()n'est pas appelée. */
    private var _binding: FragmentLetterListBinding? = null

    //la classe de liaison a déjà créé une propriété pour recyclerView, et vous n'avez pas besoin d'appeler findViewById()pour chaque vue.
    private lateinit var recyclerView: RecyclerView

    private var isLinearLayoutManager = true

    /* Ici, get() signifie que cette propriété est "get-only". Cela signifie que vous pouvez obtenir
la valeur, mais une fois attribuée (comme c'est le cas ici), vous ne pouvez pas l'attribuer à autre chose. */
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Pour afficher le menu d'options,
        setHasOptionsMenu(true)
    }

    // INFLATE LAYOUT:
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        _binding = FragmentLetterListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    // VIEW BINDING ( lier des propriétés à des views spécifique)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        chooseLayout()
    }

    // Réinitialisez la _binding propriété sur null, car la vue n'existe plus.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    private fun chooseLayout() {
        when (isLinearLayoutManager) {
            true -> {
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = LetterAdapter()
            }
            false -> {
                recyclerView.layoutManager = GridLayoutManager(context, 4)
                recyclerView.adapter = LetterAdapter()
            }
        }
    }


    // MENU:
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}