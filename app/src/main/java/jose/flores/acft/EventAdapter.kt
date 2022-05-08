package jose.flores.acft

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jose.flores.acft.databinding.EventItemBinding

class EventAdapter(var events: List<Event>): RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    var onItemClick:((Event) -> Unit)? = null
    class EventViewHolder(val binding:EventItemBinding): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(EventItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
with(holder){
    with(events[position]){
        holder.binding.eventImage.setImageResource(this.eventImage)
        holder.binding.textViewEventTitle.text = this.title
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(events[position])
        }
    }
}


    }

    override fun getItemCount():Int {

        return events.size
    }
}