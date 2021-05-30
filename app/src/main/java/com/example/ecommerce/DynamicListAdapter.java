package com.example.ecommerce;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;

public class DynamicListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int FIRST_LIST_ITEM_VIEW = 1;
    private static final int FIRST_LIST_HEADER_VIEW = 2;
    private static final int SECOND_LIST_ITEM_VIEW = 3;
    private static final int SECOND_LIST_HEADER_VIEW = 4;
    private static final int THIRD_LIST_ITEM_VIEW = 5;
    private static final int THIRD_LIST_HEADER_VIEW = 6;
    private static final int FOURTH_LIST_ITEM_VIEW = 7;
    private static final int FOURTH_LIST_HEADER_VIEW = 8;


    private ArrayList<ListObject> firstList = new ArrayList<>();
    private ArrayList<ListObject> secondList = new ArrayList<>();
    private ArrayList<ListObject> thirdList = new ArrayList<>();
    private ArrayList<ListObject> fourthList = new ArrayList<>();


    public DynamicListAdapter() {
    }

    public void setFirstList(ArrayList<ListObject> firstList) {
        this.firstList = firstList;
    }

    public void setSecondList(ArrayList<ListObject> secondList) {
        this.secondList = secondList;
    }

    public void setThirdList(ArrayList<ListObject> thirdList) { this.thirdList = thirdList;}

    public void setFourthList(ArrayList<ListObject> fourthList) { this.fourthList = fourthList;}



    public class ViewHolder extends RecyclerView.ViewHolder {
        // List items of first list
        private TextView mTextDescription1;
        private TextView mListItemTitle1;

        // List items of second list
        private TextView mTextDescription2;
        private TextView mListItemTitle2;

        // List items of third list
        private TextView mTextDescription3;
        private TextView mListItemTitle3;


        // List items of fourth list
        private TextView mTextDescription4;
        private TextView mListItemTitle4;


        // Element of footer view

        public ViewHolder(final View itemView) {
            super(itemView);

            // Get the view of the elements of first list
            mTextDescription1 = itemView.findViewById(R.id.description1);
            mListItemTitle1 = itemView.findViewById(R.id.title1);

            // Get the view of the elements of second list
            mTextDescription2 = itemView.findViewById(R.id.description2);
            mListItemTitle2 = itemView.findViewById(R.id.title2);

            // Get the view of the elements of third list
            mTextDescription3 =  itemView.findViewById(R.id.description3);
            mListItemTitle3 =  itemView.findViewById(R.id.title3);

            // Get the view of the elements of fourth list
            mTextDescription4 =  itemView.findViewById(R.id.description4);
            mListItemTitle4 =  itemView.findViewById(R.id.title4);
        }

        public void bindViewFourthList(int pos) {

            if (thirdList == null) pos = pos - 1;
            else {
                if (thirdList.size() == 0) pos = pos - 1;
                else pos = pos - thirdList.size() - 2;
            }

            final String description = fourthList.get(pos).getDescription();
            final String title = fourthList.get(pos).getTitle();

            mTextDescription4.setText(description);
            mListItemTitle4.setText(title);
        }


        public void bindViewThirdList(int pos) {

            if (secondList == null) pos = pos - 1;
            else {
                if (secondList.size() == 0) pos = pos - 1;
                else pos = pos - secondList.size() - 2;
            }

            final String description = thirdList.get(pos).getDescription();
            final String title = thirdList.get(pos).getTitle();

            mTextDescription3.setText(description);
            mListItemTitle3.setText(title);
        }

        public void bindViewSecondList(int pos) {

            if (firstList == null) pos = pos - 1;
            else {
                if (firstList.size() == 0) pos = pos - 1;
                else pos = pos - firstList.size() - 2;
            }

            final String description = secondList.get(pos).getDescription();
            final String title = secondList.get(pos).getTitle();

            mTextDescription2.setText(description);
            mListItemTitle2.setText(title);
        }

        public void bindViewFirstList(int pos) {

            // Decrease pos by 1 as there is a header view now.
            pos = pos - 1;

            final String description = firstList.get(pos).getDescription();
            final String title = firstList.get(pos).getTitle();

            mTextDescription1.setText(description);
            mListItemTitle1.setText(title);
        }

    }

    public class FooterViewHolder extends ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class FirstListHeaderViewHolder extends ViewHolder {
        public FirstListHeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class FirstListItemViewHolder extends ViewHolder {
        public FirstListItemViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class SecondListHeaderViewHolder extends ViewHolder {
        public SecondListHeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class SecondListItemViewHolder extends ViewHolder {
        public SecondListItemViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class ThirdListHeaderViewHolder extends ViewHolder {
        public ThirdListHeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class ThirdListItemViewHolder extends ViewHolder {
        public ThirdListItemViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class FourthListHeaderViewHolder extends ViewHolder {
        public FourthListHeaderViewHolder(View itemView) { super(itemView); }
    }

    private class FourthListItemViewHolder extends ViewHolder {
        public FourthListItemViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;

         if (viewType == FIRST_LIST_ITEM_VIEW) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_first_list, parent, false);
            return new FirstListItemViewHolder(v);


        } else if (viewType == FIRST_LIST_HEADER_VIEW) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_first_list_header, parent, false);
            return new FirstListHeaderViewHolder(v);


        } else if (viewType == SECOND_LIST_HEADER_VIEW) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_second_list_header, parent, false);
            return new SecondListHeaderViewHolder(v);


        } else if (viewType == SECOND_LIST_ITEM_VIEW){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_second_list, parent, false);
            return new SecondListItemViewHolder(v);

        }
         else if(viewType == THIRD_LIST_HEADER_VIEW) {
             v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_third_list_header, parent, false);
             return new ThirdListHeaderViewHolder(v);

         }
         else if(viewType == THIRD_LIST_ITEM_VIEW) {
             v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_third_list, parent, false);
             return  new ThirdListItemViewHolder(v);

         }
         else if(viewType == FOURTH_LIST_HEADER_VIEW) {
             v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_fourth_list_header, parent, false);
             return  new FourthListHeaderViewHolder(v);

         }
         else {
            //FOURTH_LIST_ITEM_VIEW
             v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_fourth_list, parent, false);
             return new FourthListItemViewHolder(v);

         }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        try {
            if (holder instanceof SecondListItemViewHolder) {
                SecondListItemViewHolder vh = (SecondListItemViewHolder) holder;
                vh.bindViewSecondList(position);

            } else if (holder instanceof FirstListHeaderViewHolder) {
                FirstListHeaderViewHolder vh = (FirstListHeaderViewHolder) holder;

            } else if (holder instanceof FirstListItemViewHolder) {
                FirstListItemViewHolder vh = (FirstListItemViewHolder) holder;
                vh.bindViewFirstList(position);

            } else if (holder instanceof SecondListHeaderViewHolder) {
                SecondListHeaderViewHolder vh = (SecondListHeaderViewHolder) holder;

            } else if (holder instanceof ThirdListHeaderViewHolder) {
                ThirdListHeaderViewHolder vh = (ThirdListHeaderViewHolder) holder;

            }else if (holder instanceof ThirdListItemViewHolder) {
                ThirdListItemViewHolder vh = (ThirdListItemViewHolder) holder;
                vh.bindViewThirdList(position);

            }else if (holder instanceof FourthListHeaderViewHolder) {
                FourthListHeaderViewHolder vh = (FourthListHeaderViewHolder) holder;

            }else if (holder instanceof FourthListItemViewHolder) {
                FourthListItemViewHolder vh = (FourthListItemViewHolder) holder;
                vh.bindViewFourthList(position);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {

        int firstListSize = 0;
        int secondListSize = 0;
        int thirdListSize = 0;
        int fourthListSize = 0;

        if (secondList == null && firstList == null && thirdList == null && fourthList == null) return 0;

        if (secondList != null)
            secondListSize = secondList.size();
        if (firstList != null)
            firstListSize = firstList.size();
        if (thirdList != null)
            thirdListSize = thirdList.size();
        if (fourthList != null)
            fourthListSize = fourthList.size();

        if (secondListSize > 0 && firstListSize > 0 && thirdListSize > 0 && fourthListSize > 0)
            return 1 + firstListSize + secondListSize + 1 + thirdListSize + 1 + fourthListSize;   // first list header, first list size, second list header , second list size, footer

        else return 0;
    }

    @Override
    public int getItemViewType(int position) {

        int firstListSize = 0;
        int secondListSize = 0;
        int thirdListSize = 0;
        int fourthListSize = 0;

        if (secondList == null && firstList == null && fourthList == null && thirdList == null)
            return super.getItemViewType(position);

        if (secondList != null)
            secondListSize = secondList.size();
        if (firstList != null)
            firstListSize = firstList.size();

        if (thirdList != null)
            thirdListSize = thirdList.size();
        if (fourthList != null)
            fourthListSize = fourthList.size();

        if (secondListSize > 0 && firstListSize > 0 && thirdListSize > 0 && fourthListSize > 0) {
            if (position == 0) return FIRST_LIST_HEADER_VIEW;
            else if (position == firstListSize)
                return FIRST_LIST_ITEM_VIEW;
            else if (position == firstListSize + 1)
                return SECOND_LIST_HEADER_VIEW;
            else if (position == secondListSize)
                return SECOND_LIST_ITEM_VIEW;
            else if (position == secondListSize + 1)
                return THIRD_LIST_HEADER_VIEW;
            else if (position == thirdListSize)
                return THIRD_LIST_ITEM_VIEW;
            else if (position == thirdListSize + 1)
                return FOURTH_LIST_HEADER_VIEW;
            else if (position == fourthListSize)
                return FOURTH_LIST_ITEM_VIEW;


        }
        return super.getItemViewType(position);
    }
}