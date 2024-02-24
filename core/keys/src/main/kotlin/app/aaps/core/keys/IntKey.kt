package app.aaps.core.keys

enum class IntKey(
    override val key: Int,
    val defaultValue: Int,
    val min: Int,
    val max: Int,
    override val defaultedBySM: Boolean = false,
    val calculatedDefaultValue: Boolean = false,
    override val showInApsMode: Boolean = true,
    override val showInNsClientMode: Boolean = true,
    override val showInPumpControlMode: Boolean = true,
    override val dependency: BooleanKey? = null,
    override val negativeDependency: BooleanKey? = null,
    override val hideParentScreenIfHidden: Boolean = false,
    val engineeringModeOnly: Boolean = false
) : PreferenceKey {

    OverviewCarbsButtonIncrement1(R.string.key_carbs_button_increment_1, 5, -50, 50, defaultedBySM = true),
    OverviewCarbsButtonIncrement2(R.string.key_carbs_button_increment_2, 10, -50, 50, defaultedBySM = true),
    OverviewCarbsButtonIncrement3(R.string.key_carbs_button_increment_3, 20, -50, 50, defaultedBySM = true),
    OverviewEatingSoonDuration(R.string.key_eating_soon_duration, 45, 15, 120, defaultedBySM = true, hideParentScreenIfHidden = true),
    OverviewActivityDuration(R.string.key_activity_duration, 90, 15, 600, defaultedBySM = true),
    OverviewHypoDuration(R.string.key_hypo_duration, 60, 15, 180, defaultedBySM = true),
    OverviewCageWarning(R.string.key_statuslights_cage_warning, 48, 24, 240, defaultedBySM = true),
    OverviewCageCritical(R.string.key_statuslights_cage_critical, 72, 24, 240, defaultedBySM = true),
    OverviewIageWarning(R.string.key_statuslights_iage_warning, 72, 24, 240, defaultedBySM = true),
    OverviewIageCritical(R.string.key_statuslights_iage_critical, 144, 24, 240, defaultedBySM = true),
    OverviewSageWarning(R.string.key_statuslights_sage_warning, 216, 24, 720, defaultedBySM = true),
    OverviewSageCritical(R.string.key_statuslights_sage_critical, 240, 24, 720, defaultedBySM = true),
    OverviewSbatWarning(R.string.key_statuslights_sbat_warning, 25, 0, 100, defaultedBySM = true),
    OverviewSbatCritical(R.string.key_statuslights_sbat_critical, 5, 0, 100, defaultedBySM = true),
    OverviewBageWarning(R.string.key_statuslights_bage_warning, 216, 24, 1000, defaultedBySM = true),
    OverviewBageCritical(R.string.key_statuslights_bage_critical, 240, 24, 1000, defaultedBySM = true),
    OverviewResWarning(R.string.key_statuslights_res_warning, 80, 0, 300, defaultedBySM = true),
    OverviewResCritical(R.string.key_statuslights_res_critical, 10, 0, 300, defaultedBySM = true),
    OverviewBattWarning(R.string.key_statuslights_bat_warning, 51, 0, 100, defaultedBySM = true),
    OverviewBattCritical(R.string.key_statuslights_bat_critical, 26, 0, 100, defaultedBySM = true),
    OverviewBolusPercentage(R.string.key_boluswizard_percentage, 100, 10, 100),
    OverviewResetBolusPercentageTime(R.string.key_reset_boluswizard_percentage_time, 16, 6, 120, defaultedBySM = true, engineeringModeOnly = true),
    GeneralProtectionTimeout(R.string.key_protection_timeout, 1, 1, 180, defaultedBySM = true),
    SafetyMaxCarbs(R.string.key_safety_max_carbs, 48, 1, 200),
    LoopOpenModeMinChange(R.string.key_loop_open_mode_min_change, 30, 0, 50, defaultedBySM = true),
    ApsMaxSmbFrequency(R.string.key_openaps_smb_interval, 3, 1, 10, defaultedBySM = true),
    ApsMaxMinutesOfBasalToLimitSmb(R.string.key_openaps_smb_max_minutes, 30, 15, 120, defaultedBySM = true),
    ApsUamMaxMinutesOfBasalToLimitSmb(R.string.key_openaps_uam_smb_max_minutes, 30, 15, 120, defaultedBySM = true),
    ApsCarbsRequestThreshold(R.string.key_openaps_carbs_required_threshold, 1, 1, 10, defaultedBySM = true),
    ApsDynIsfAdjustmentFactor(R.string.key_dynamic_isf_adjustment_factor, 100, 1, 300, dependency = BooleanKey.ApsUseDynamicSensitivity),
    AutosensPeriod(R.string.key_openapsama_autosens_period, 24, 4, 24, calculatedDefaultValue = true),
    MaintenanceLogsAmount(R.string.key_maintenance_logs_amount, 2, 1, 10, defaultedBySM = true),
    AlertsStaleDataThreshold(R.string.key_missed_bg_readings_threshold_minutes, 30, 15, 10000, defaultedBySM = true),
    AlertsPumpUnreachableThreshold(R.string.key_pump_unreachable_threshold_minutes, 30, 30, 300, defaultedBySM = true),
    InsulinOrefPeak(R.string.key_insulin_oref_peak, 75, 35, 120, hideParentScreenIfHidden = true),

    AutotuneDefaultTuneDays(R.string.key_autotune_default_tune_days, 5, 1, 30),

    SmsRemoteBolusDistance(R.string.key_smscommunicator_remote_bolus_min_distance, 15, 3, 60),
    OApsAIMIDynISFAdjustment(R.string.key_DynISF_Adjust,100,1,500),
    OApsAIMIDynISFAdjustmentHyper(R.string.key_DynISFAdjusthyper,150,1,500),
    OApsAIMImealAdjISFFact(R.string.key_oaps_aimi_mealAdjFact,50,1,500),
    OApsAIMIDynISFFactor01(R.string.key_oaps_aimi_dynisf_factor_0_1, 70, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor12(R.string.key_oaps_aimi_dynisf_factor_1_2, 70, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor23(R.string.key_oaps_aimi_dynisf_factor_2_3, 70, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor34(R.string.key_oaps_aimi_dynisf_factor_3_4, 70, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor45(R.string.key_oaps_aimi_dynisf_factor_4_5, 70, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor56(R.string.key_oaps_aimi_dynisf_factor_5_6, 70, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor67(R.string.key_oaps_aimi_dynisf_factor_6_7, 70, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor78(R.string.key_oaps_aimi_dynisf_factor_7_8, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor89(R.string.key_oaps_aimi_dynisf_factor_8_9, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor910(R.string.key_oaps_aimi_dynisf_factor_9_10, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor1011(R.string.key_oaps_aimi_dynisf_factor_10_11, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor1112(R.string.key_oaps_aimi_dynisf_factor_11_12, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor1213(R.string.key_oaps_aimi_dynisf_factor_12_13, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor1314(R.string.key_oaps_aimi_dynisf_factor_13_14, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor1415(R.string.key_oaps_aimi_dynisf_factor_14_15, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor1516(R.string.key_oaps_aimi_dynisf_factor_15_16, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor1617(R.string.key_oaps_aimi_dynisf_factor_16_17, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor1718(R.string.key_oaps_aimi_dynisf_factor_17_18, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor1819(R.string.key_oaps_aimi_dynisf_factor_18_19, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor1920(R.string.key_oaps_aimi_dynisf_factor_19_20, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor2021(R.string.key_oaps_aimi_dynisf_factor_20_21, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor2122(R.string.key_oaps_aimi_dynisf_factor_21_22, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor2223(R.string.key_oaps_aimi_dynisf_factor_22_23, 85, 1, 500, defaultedBySM = true),
    OApsAIMIDynISFFactor2324(R.string.key_oaps_aimi_dynisf_factor_23_24, 85, 1, 500, defaultedBySM = true)
}