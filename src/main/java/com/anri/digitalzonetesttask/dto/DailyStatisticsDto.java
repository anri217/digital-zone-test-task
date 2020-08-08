package com.anri.digitalzonetesttask.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyStatisticsDto {

    private Long visitsCountByCurDay;

    private Long distUsersCountByCurDay;
}
