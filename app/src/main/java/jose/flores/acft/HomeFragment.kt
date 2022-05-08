package jose.flores.acft

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import jose.flores.acft.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var repository: Repository
    private var _binding:FragmentHomeBinding?=null
    private val binding get() = _binding!!

    private lateinit var adapter: EventAdapter
    private lateinit var events:List<Event>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        repository = Repository()
        events = repository.getEvents()

        val eventsRecyclerView = binding.eventsRV

        eventsRecyclerView.layoutManager = LinearLayoutManager(context)


        adapter = EventAdapter(events)

        eventsRecyclerView.adapter = adapter

        adapter.onItemClick = {
            Navigation.findNavController(binding.root).navigate(R.id.eventDetailsActivity)
        }


        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        //VOIDS MEMORY LEAKS!!
        _binding = null
    }
}