package com.example.android_application.presentation.Details.Leaf;


import com.example.android_application.Data.Leaf.LeafFormat;
import com.example.android_application.Data.Leaf.LeafParam;
import com.example.android_application.util.DataUnavailableException;
import com.example.android_application.util.WrongRequestException;

public interface LeafContract {
    interface View{
        public void setUpContent(LeafFormat leafFormat);
        public void handleWrongRequest(WrongRequestException exception);
        public void handleDataUnavailable(DataUnavailableException exception);
    }
    interface Presenter{
        void loadLeaf(LeafParam leafParam);
        void bindView(LeafFormat leafFormat);
    }
}
