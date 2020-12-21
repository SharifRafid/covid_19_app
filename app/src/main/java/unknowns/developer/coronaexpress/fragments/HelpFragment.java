package unknowns.developer.coronaexpress.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import unknowns.developer.coronaexpress.MainActivity;
import unknowns.developer.coronaexpress.R;


public class HelpFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_help, container, false);

        final Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.fade);

        final Button hotline333 = view.findViewById(R.id.hotline);

        hotline333.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).makeCall("333");
                hotline333.startAnimation(animation);
            }
        });

        final Button nationalcallcenter = view.findViewById(R.id.nationalCallCenter);

        nationalcallcenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nationalcallcenter.startAnimation(animation);
                ((MainActivity) getActivity()).makeCall("16263");
            }
        });

        final Button healthPortal = view.findViewById(R.id.healthPortal);

        healthPortal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                healthPortal.startAnimation(animation);
                ((MainActivity) getActivity()).makeCall("10655");
            }
        });

        final Button iedcr = view.findViewById(R.id.IEDCR);

        iedcr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iedcr.startAnimation(animation);
                ((MainActivity) getActivity())
                        .makeCall("09611677777");
            }
        });

        final Button spclsthlpline = view.findViewById(R.id.specialistLine);

        spclsthlpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spclsthlpline.startAnimation(animation);
                ((MainActivity) getActivity())
                        .makeCall("109");
            }
        });

        return view;
    }
}
