package jose.flores.acft


import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import jose.flores.acft.databinding.ActivityEventDetailsBinding

class EventDetailsActivity : AppCompatActivity() {

    private lateinit var youTubePlayerView: YouTubePlayerView
    private lateinit var binding: ActivityEventDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        this.supportActionBar?.title = "MDL"
        this.supportActionBar?.subtitle = "Deadlift the maximum weight possible three times."
        binding = ActivityEventDetailsBinding.inflate(layoutInflater)

        youTubePlayerView = binding.youtubePlayerView
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = "S0Q4gqBUs7c"
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })

        setContentView(binding.root)
    }


    override fun onDestroy() {
        super.onDestroy()
        //AVOIDS MEMORY LEAKS!!
        youTubePlayerView.release();
    }
}
