package com.github.vndovr.payment;

import com.github.vndovr.col.beneficiary.BeneficiaryROShort;
import com.github.vndovr.col.holiday.PublicHolidayRO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequisiteRO {

  BeneficiaryROShort[] beneficiaries;

  PublicHolidayRO[] publicHolidays;

}
