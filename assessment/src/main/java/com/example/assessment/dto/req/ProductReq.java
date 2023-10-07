package com.example.assessment.dto.req;

import com.example.assessment.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductReq {
    String name;
    Category category;
    int price;
}
