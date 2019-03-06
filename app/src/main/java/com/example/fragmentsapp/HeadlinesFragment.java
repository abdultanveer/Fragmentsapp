package com.example.fragmentsapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link HeadlinesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeadlinesFragment extends Fragment implements AdapterView.OnItemClickListener {


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//step 3
        String headlines = parent.getItemAtPosition(position).toString();
        Toast.makeText(getContext(), headlines, Toast.LENGTH_SHORT).show();
        mListener.onArticleSelected(headlines);
    }

    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(String headlines);
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ListView headlinesListView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnHeadlineSelectedListener mListener;

    public HeadlinesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HeadlinesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HeadlinesFragment newInstance(String param1, String param2) {
        HeadlinesFragment fragment = new HeadlinesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {//step 2b
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    //here the layout gets inflated and ui will be shown
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,//step 2c
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_headlines, container, false);//view = fragment_headlines.xml
        headlinesListView = view.findViewById(R.id.headlinesListview);
        headlinesListView.setOnItemClickListener(this);
        return  view;
    }

    // TODO: Rename method, update argument and hook method into UI event
   /* public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

   @Override
    public void onAttach(Context context) {//step 2a
        super.onAttach(context);
        mListener = (OnHeadlineSelectedListener)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
   /* public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
