package com.puzzle.likelion.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StarAverage {
    // 별점을 각각 몇개 받았는지 알기 위해 필요한 필드들
    private int oneCount;
    private int twoCount;
    private int threeCount;
    private int fourCount;
    private int fiveCount;

    // 평균 별점을 알기 위해 필요한 필드들
    private int totalCount;
    private int totalRating;
    private double ratingAverage;
}
