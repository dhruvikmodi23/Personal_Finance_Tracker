package com.example.financeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShowTransaction extends RecyclerView.Adapter<ShowTransaction.TransactionViewHolder> {

    private ArrayList<Transaction> transactions;
    private OnTransactionRemoveListener removeListener;

    public ShowTransaction(ArrayList<Transaction> transactions, OnTransactionRemoveListener listener) {
        this.transactions = transactions;
        this.removeListener = listener;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction, parent, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        Transaction transaction = transactions.get(position);
        holder.tvDescription.setText(transaction.getDescription());
        holder.tvAmount.setText(String.valueOf(transaction.getAmount()));
        holder.tvId.setText("ID: " + transaction.getId());

        // Handle the remove button click
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeListener.onTransactionRemove(transaction.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    // ViewHolder class
    public static class TransactionViewHolder extends RecyclerView.ViewHolder {
        TextView tvDescription, tvAmount, tvId;
        Button btnRemove;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            tvId = itemView.findViewById(R.id.tvId);
            btnRemove = itemView.findViewById(R.id.btnRemove);
        }
    }

    // Listener interface for transaction removal
    public interface OnTransactionRemoveListener {
        void onTransactionRemove(int transactionId);
    }
}
