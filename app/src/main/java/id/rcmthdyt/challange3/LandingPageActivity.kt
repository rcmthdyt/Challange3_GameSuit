package id.rcmthdyt.challange3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.rcmthdyt.challange3.databinding.ActivityLandingPageBinding
import id.rcmthdyt.challange3.landingpage.LandingPageOne
import id.rcmthdyt.challange3.landingpage.LandingPageThree
import id.rcmthdyt.challange3.landingpage.LandingPageTwo
import id.rcmthdyt.challange3.landingpage.LandingPagerAdapter


class LandingPageActivity : AppCompatActivity() {
    private var _binding: ActivityLandingPageBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        _binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(_binding?.root)


        val pagerAdapter = LandingPagerAdapter(fragmentActivity = this)

        _binding?.layoutViewPager?.adapter = pagerAdapter
        _binding?.dotIndicator?.attachTo(_binding?.layoutViewPager!!)

        pagerAdapter.setFragments(
            listOf(
                LandingPageOne(),
                LandingPageTwo(),
                LandingPageThree(),
            )
        )
    }
}