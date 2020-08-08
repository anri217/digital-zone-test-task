package com.anri.digitalzonetesttask.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyStatisticsDto {

    @NonNull
    private Long visitsCountByCurDay;

    @NonNull
    private Long distUsersCountByCurDay;
}
