package com.anri.digitalzonetesttask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyStatisticsDto {

    private Long visitsCountByCurDay;

    private Long distUsersCountByCurDay;
}
