package android.bigandbo.com.footballlineup.Adapters;

import android.bigandbo.com.footballlineup.R;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by hieunt on 9/11/2015.
 */
public class AdapterAssociation extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final static int TYPE_ITEM = 1;
    private final static int TYPE_HEADER = 0;
    private LayoutInflater inflater;
    private Context mContext;
    private List<String> mData;

    public AdapterAssociation(Context context, List<String> data){
        inflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mData = data;
    }

    private int getBasicItemCount(){
        return mData == null ? 0 : mData.size();
    }

    @Override
    public int getItemCount() {
        return getBasicItemCount() + 1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_HEADER;
        }else {
            return TYPE_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER){
            View view = inflater.inflate(R.layout.item_association_header, parent, false);
            return new HeaderViewHolder(view);
        }else if(viewType == TYPE_ITEM){
            View view = inflater.inflate(R.layout.item_association, parent, false);
            return new ItemViewHolder(view);
        }
        throw new RuntimeException("There is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView imvBanner;
        public ItemViewHolder(View view){
            super(view);
            imvBanner = (SimpleDraweeView) view.findViewById(R.id.imv_association);
        }
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder{
        public HeaderViewHolder(View view){
            super(view);
        }
    }
}
