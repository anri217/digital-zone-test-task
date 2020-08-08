package com.anri.digitalzonetesttask.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodStatisticsDto {

    @NonNull
    private Long visitsCountByPeriod;

    @NonNull
    private Long distUsersCountByPeriod;

    @NonNull
    private Long permanentUsersCountByPeriod;
}
