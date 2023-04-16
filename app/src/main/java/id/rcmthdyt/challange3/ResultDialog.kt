package id.rcmthdyt.challange3

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import id.rcmthdyt.challange3.databinding.DialogResultBinding
import id.rcmthdyt.challange3.landingpage.LandingPageThree


class ResultDialog : DialogFragment() {
    private var _binding: DialogResultBinding? = null

    // This property is only valid between onCreateDialog and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = DialogResultBinding.inflate(LayoutInflater.from(context))


        val data = arguments
        val dataPemenang = data?.get("status").toString()
        val gameModeId = data?.getInt(GameModeActivity.GAME_MODE_ID)
        val playerName = data?.get(LandingPageThree.PLAYER_NAME).toString()


        _binding?.tvPemenang?.text = dataPemenang
        Log.d("args", dataPemenang)

        _binding?.btnTvMainLagi?.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            Log.d("args", playerName)
            Log.d("args", gameModeId.toString())
            intent.putExtra(GameModeActivity.GAME_MODE_ID, gameModeId)
            intent.putExtra(LandingPageThree.PLAYER_NAME, playerName)
            startActivity(intent)
        }
        _binding?.btnTvToGameMode?.setOnClickListener {
            val intent = Intent(activity, GameModeActivity::class.java)
            Log.d("args", playerName)
            intent.putExtra(LandingPageThree.PLAYER_NAME, playerName)
            startActivity(intent)
        }

        return AlertDialog.Builder(requireActivity())
            .setView(binding.root)
            .create()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}