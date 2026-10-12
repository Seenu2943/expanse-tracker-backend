
    package com.expansetracker.expanse_tracker.dto;

    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Positive;
    import jakarta.validation.constraints.Size;
    import java.math.BigDecimal;
    import java.time.LocalDate;


    public class ExpanseDTO {

        @NotBlank(message = "Title is reqired")
        private String title;
        @NotNull(message = "Amount is required")
        @Positive(message = "Amount must be greater than zero")
        private Double amount;

        @NotBlank(message = "Catagory is reqired")
        private String category;
        @NotBlank(message = "Title is reqired")
        private String date;
        @Size(max = 200, message = "Description cannot exceed 200 characters")
        private String description;



        // Default constructor
        public ExpanseDTO() {
        }

        // Getters and setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

