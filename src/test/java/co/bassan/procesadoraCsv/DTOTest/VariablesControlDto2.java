package co.bassan.procesadoraCsv.DTOTest;

import co.bassan.lectora.anotaciones.DatosCampo;
import co.bassan.lectora.anotaciones.ValidarCampo;

import java.util.Date;

/**
 * Created by sebas on 19/04/15.
 */
public class VariablesControlDto2 extends  PersonaDto{

    private String gestacion_14;
    private String sifilisGestacionalOCongenita_15;
    private String hipertencionInducidaPorLaGestacion_16;
    private String hipotiroidismoCongenito_17;
    private String sintomaticoRespiratorio_18;
    private String tbcMultidrogoresistente_19;
    private String lepra_20;
    private String obesidadODesnutricionProteicoCalorica_21;
    private String victimaDeMaltrato_22;
    private String victimasDeViolenciaSexual_23;
    private String infeccionesDeTransmisionSexual_24;
    private String enfermedadMental_25;
    private String cancerDeCervix_26;
    private String cancerDeSeno_27;
    private String fluorosisDental_28;
    private Date fechaDelPeso_29;
    private Double pesoEnKg_30;
    private Date fechaDeLaTalla_31;
    private Double tallaEnCm_32;
    private String fechaProbableDelParto_33;
    private String edadGestacionalAlNacer_34;
    private String bcg_35;
    private String hepatitisBMenoresDe1Ano_36;
    private String pentavelente_37;
    private String polio_38;
    private String dptMenoresDe5Anos_39;
    private String rotavirus_40;
    private String neumococo_41;
    private String influenzaNinos_42;
    private String fiebreAmarillaNinos1Ano_43;
    private String hepatitisA_44;
    private String tripleViralNinos_45;
    private String virusDelPapilomaHumano_46;
    private String tdOTtMujeresEdadFertil_47;
    private String controlDePlacaBacteriana_48;
    private Date fechaAtencionPartoOCesarea_49;
    private Date fechaSalidaAtencionPartoOCesarea_50;
    private String fechaConsejeriaLactanciaMaterna_51;
    private String controlDelRecienNacido_52;
    private String planificacionFaminiarPrimerVez_53;
    private String suministroDeMetodoAnticonceptivo_54;
    private String fechaSuministroMetodoAnticonceptivo_55;
    private String controlPrenatalPrimeraVez_56;
    private String controlPrenatal_57;
    private String ultimoControlPrenatal_58;
    private String suministroDeAcidoFolicoUltimoControlPrenatal_59;
    // Variable 60: Suministro de Sulfato ferroso en el último control prenatal
    private String suministroSulfatoFerrosoUltimoControlPrenatal_60;
    @DatosCampo(posicion = 60)
    @ValidarCampo(requirido = true)
    // Variable 61: Suministro de Carbonato de Calcio en el último control prenatal
    private String suministroCarbonatoCalcioUltimoControlPrenatal_61;
    @DatosCampo(posicion = 61)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date valoracionAgudezaVisual_62;
    @DatosCampo(posicion = 62)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date consultaPorOftalmologia_63;
    @DatosCampo(posicion = 63)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date fechaDiagnosticoDesnutricionProteicoCalorica_64;
    @DatosCampo(posicion = 64)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date consultaMujerOMenorVictimaDeMaltrato_65;
    @DatosCampo(posicion = 65)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date consultaVictimasViolenciaSexual_66;
    @DatosCampo(posicion = 66)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date consultaNutricion_67;
    @DatosCampo(posicion = 67)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date consultaPsicologia_68;
    @DatosCampo(posicion = 68)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date consultaCrecimientoDesarrollo_69;
    @DatosCampo(posicion = 69)
    @ValidarCampo(requirido = true)
    private String suministroSultafoFerrosoUltimaConsultaMenor10Anos_70;
    @DatosCampo(posicion = 70)
    @ValidarCampo(requirido = true)
    private String suministroVitaminaAUltimaConsultaMenor10Anos_71;
    @DatosCampo(posicion = 71)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date consultaJovenOrimeraVez_72;
    @DatosCampo(posicion = 72)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date consultaAdultoPrimeraVez_73;
    @DatosCampo(posicion = 73)
    @ValidarCampo(requirido = true)
    private String preservativosEntregadosPacienteIts_74;
    @DatosCampo(posicion = 74)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date asesoriaPreTestVih_75;
    @DatosCampo(posicion = 75)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date asesoriaPostTestElisaVih_76;
    @DatosCampo(posicion = 76)
    @ValidarCampo(requirido = true)
    // Variable 77: Paciente con Diagnóstico de: Ansiedad, Depresión, Esquizofrenia, déficit de atención, consumo SPA y Bipolaridad recibió Atención en los últimos 6 meses por Equipo Interdisciplinario Completo.
    private String pacienteDiagnosticoUltimos6MesesEquipoInterCompleto_77;
    @DatosCampo(posicion = 77)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date fechaAntigenoSuperficieHepatitisBenGestantes_78;
    @DatosCampo(posicion = 78)
    @ValidarCampo(requirido = true)
    private String resultadoAntigenoSuperficieHepatitisB_79;
    @DatosCampo(posicion = 79)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date fechaSerologiaSifilis_80;
    @DatosCampo(posicion = 80)
    @ValidarCampo(requirido = true)
    private String resultadoSerologíaSífilis_81;
    @DatosCampo(posicion = 81)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date fechaTomaElisaVIH_82;
    @DatosCampo(posicion = 82)
    @ValidarCampo(requirido = true)
    private String resultadoElisaVIH_83;
    @DatosCampo(posicion = 83)
    @ValidarCampo(requirido = true)
    private String fechaTshNeonatal_84;
    @DatosCampo(posicion = 84)
    @ValidarCampo(requirido = true)
    private String resultadoTshNeonatal_85;
    @DatosCampo(posicion = 85)
    @ValidarCampo(requirido = true)
    private String tamizajeCancerCuelloUterino_86;
    @DatosCampo(posicion = 86)
    @ValidarCampo(requirido = true)
    private String citologiaCervicoUterina_87;
    @DatosCampo(posicion = 87)
    @ValidarCampo(requirido = true)
    private String citologiaCervicoUterinaResultadosSegunBethesda_88;
    @DatosCampo(posicion = 88)
    @ValidarCampo(requirido = true)
    private String calidadEnMuestraCitologiaCervicoUterina_89;
    @DatosCampo(posicion = 89)
    @ValidarCampo(requirido = true)
    private String codigoHabilitacionIpsTomaCitologiaCervicoUterina_90;
    @DatosCampo(posicion = 90)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date fechaColposcopia_91;
    @DatosCampo(posicion = 91)
    @ValidarCampo(requirido = true)
    private String codigoHabilitacionIpsTomaColposcopia_92;
    @DatosCampo(posicion = 92)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date fechaBiopsiaCervical_93;
    @DatosCampo(posicion = 93)
    @ValidarCampo(requirido = true)
    private String resultadoBiopsiaCervical_94;
    @DatosCampo(posicion = 94)
    @ValidarCampo(requirido = true)
    private String codigoHabilitacionIpsTomaBiopsiaCervical_95;
    @DatosCampo(posicion = 95)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date fechaDeMamografia_96;
    @DatosCampo(posicion = 96)
    @ValidarCampo(requirido = true)
    private String resultadoMamografia_97;
    @DatosCampo(posicion = 97)
    @ValidarCampo(requirido = true)
    private String codigoHabilitacionIpsTomaMamografia_98;
    @DatosCampo(posicion = 98)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date fechaTomaBiopsiaSenoPorBacaf_99;
    @DatosCampo(posicion = 99)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date fechaResultadoBiopsiaSeno_100;
    @DatosCampo(posicion = 100)
    @ValidarCampo(requirido = true)
    private String resultadoBiopsiaSeno_101;
    @DatosCampo(posicion = 101)
    @ValidarCampo(requirido = true)
    private String codigoHabilitacionIpsTomaBiopsiaSeno102;
    @DatosCampo(posicion = 102)
    @ValidarCampo(requirido = true)
    private String fechaTomaHemoglobina_103;
    @DatosCampo(posicion = 103)
    @ValidarCampo(requirido = true)
    private String hemoglobina_104;
    @DatosCampo(posicion = 104)
    @ValidarCampo(requirido = true)
    private String fechaTomaGlicemiaBasal_105;
    @DatosCampo(posicion = 105)
    @ValidarCampo(requirido = true)
    private String fechaCreatinina_106;
    @DatosCampo(posicion = 106)
    @ValidarCampo(requirido = true)
    private String Creatinina_107;
    @DatosCampo(posicion = 107)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date fechaHemoglobinaGlicosilada_108;
    @DatosCampo(posicion = 108)
    @ValidarCampo(requirido = true)
    private String hemoglobinaGlicosilada_109;
    @DatosCampo(posicion = 109)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date fechaTomaMicroalbuminuria_110;
    @DatosCampo(posicion = 110)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date fechaTomaHDL_111;
    @DatosCampo(posicion = 111)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date fechaTomaBaciloscopiaDiagnostico_112;
    @DatosCampo(posicion = 112)
    @ValidarCampo(requirido = true)
    private String baciloscopiaDiagnostico_113;
    @DatosCampo(posicion = 113)
    @ValidarCampo(requirido = true)
    private String tratamientoHipotiroidismoCongenito_114;
    @DatosCampo(posicion = 114)
    @ValidarCampo(requirido = true)
    private String tratamientoSifilisGestacional_115;
    @DatosCampo(posicion = 115)
    @ValidarCampo(requirido = true)
    private String tratamientoSifilisCongenita_116;
    @DatosCampo(posicion = 116)
    @ValidarCampo(requirido = true)
    private String tratamientoLepra_117;
    @DatosCampo(posicion = 117)
    @ValidarCampo(requirido = true,formatoFecha = "yyyy-MM-dd")
    private Date fechaTerminacionTratamientoLeishmaniasis_118;

    public String getGestacion_14() {
        return gestacion_14;
    }

    public void setGestacion_14(String gestacion_14) {
        this.gestacion_14 = gestacion_14;
    }

    public String getSifilisGestacionalOCongenita_15() {
        return sifilisGestacionalOCongenita_15;
    }

    public void setSifilisGestacionalOCongenita_15(String sifilisGestacionalOCongenita_15) {
        this.sifilisGestacionalOCongenita_15 = sifilisGestacionalOCongenita_15;
    }

    public String getHipertencionInducidaPorLaGestacion_16() {
        return hipertencionInducidaPorLaGestacion_16;
    }

    public void setHipertencionInducidaPorLaGestacion_16(String hipertencionInducidaPorLaGestacion_16) {
        this.hipertencionInducidaPorLaGestacion_16 = hipertencionInducidaPorLaGestacion_16;
    }

    public String getHipotiroidismoCongenito_17() {
        return hipotiroidismoCongenito_17;
    }

    public void setHipotiroidismoCongenito_17(String hipotiroidismoCongenito_17) {
        this.hipotiroidismoCongenito_17 = hipotiroidismoCongenito_17;
    }

    public String getSintomaticoRespiratorio_18() {
        return sintomaticoRespiratorio_18;
    }

    public void setSintomaticoRespiratorio_18(String sintomaticoRespiratorio_18) {
        this.sintomaticoRespiratorio_18 = sintomaticoRespiratorio_18;
    }

    public String getTbcMultidrogoresistente_19() {
        return tbcMultidrogoresistente_19;
    }

    public void setTbcMultidrogoresistente_19(String tbcMultidrogoresistente_19) {
        this.tbcMultidrogoresistente_19 = tbcMultidrogoresistente_19;
    }

    public String getLepra_20() {
        return lepra_20;
    }

    public void setLepra_20(String lepra_20) {
        this.lepra_20 = lepra_20;
    }

    public String getObesidadODesnutricionProteicoCalorica_21() {
        return obesidadODesnutricionProteicoCalorica_21;
    }

    public void setObesidadODesnutricionProteicoCalorica_21(String obesidadODesnutricionProteicoCalorica_21) {
        this.obesidadODesnutricionProteicoCalorica_21 = obesidadODesnutricionProteicoCalorica_21;
    }

    public String getVictimaDeMaltrato_22() {
        return victimaDeMaltrato_22;
    }

    public void setVictimaDeMaltrato_22(String victimaDeMaltrato_22) {
        this.victimaDeMaltrato_22 = victimaDeMaltrato_22;
    }

    public String getVictimasDeViolenciaSexual_23() {
        return victimasDeViolenciaSexual_23;
    }

    public void setVictimasDeViolenciaSexual_23(String victimasDeViolenciaSexual_23) {
        this.victimasDeViolenciaSexual_23 = victimasDeViolenciaSexual_23;
    }

    public String getInfeccionesDeTransmisionSexual_24() {
        return infeccionesDeTransmisionSexual_24;
    }

    public void setInfeccionesDeTransmisionSexual_24(String infeccionesDeTransmisionSexual_24) {
        this.infeccionesDeTransmisionSexual_24 = infeccionesDeTransmisionSexual_24;
    }

    public String getEnfermedadMental_25() {
        return enfermedadMental_25;
    }

    public void setEnfermedadMental_25(String enfermedadMental_25) {
        this.enfermedadMental_25 = enfermedadMental_25;
    }

    public String getCancerDeCervix_26() {
        return cancerDeCervix_26;
    }

    public void setCancerDeCervix_26(String cancerDeCervix_26) {
        this.cancerDeCervix_26 = cancerDeCervix_26;
    }

    public String getCancerDeSeno_27() {
        return cancerDeSeno_27;
    }

    public void setCancerDeSeno_27(String cancerDeSeno_27) {
        this.cancerDeSeno_27 = cancerDeSeno_27;
    }

    public String getFluorosisDental_28() {
        return fluorosisDental_28;
    }

    public void setFluorosisDental_28(String fluorosisDental_28) {
        this.fluorosisDental_28 = fluorosisDental_28;
    }

    public Date getFechaDelPeso_29() {
        return fechaDelPeso_29;
    }

    public void setFechaDelPeso_29(Date fechaDelPeso_29) {
        this.fechaDelPeso_29 = fechaDelPeso_29;
    }

    public Double getPesoEnKg_30() {
        return pesoEnKg_30;
    }

    public void setPesoEnKg_30(Double pesoEnKg_30) {
        this.pesoEnKg_30 = pesoEnKg_30;
    }

    public Date getFechaDeLaTalla_31() {
        return fechaDeLaTalla_31;
    }

    public void setFechaDeLaTalla_31(Date fechaDeLaTalla_31) {
        this.fechaDeLaTalla_31 = fechaDeLaTalla_31;
    }

    public Double getTallaEnCm_32() {
        return tallaEnCm_32;
    }

    public void setTallaEnCm_32(Double tallaEnCm_32) {
        this.tallaEnCm_32 = tallaEnCm_32;
    }

    public String getFechaProbableDelParto_33() {
        return fechaProbableDelParto_33;
    }

    public void setFechaProbableDelParto_33(String fechaProbableDelParto_33) {
        this.fechaProbableDelParto_33 = fechaProbableDelParto_33;
    }

    public String getEdadGestacionalAlNacer_34() {
        return edadGestacionalAlNacer_34;
    }

    public void setEdadGestacionalAlNacer_34(String edadGestacionalAlNacer_34) {
        this.edadGestacionalAlNacer_34 = edadGestacionalAlNacer_34;
    }

    public String getBcg_35() {
        return bcg_35;
    }

    public void setBcg_35(String bcg_35) {
        this.bcg_35 = bcg_35;
    }

    public String getHepatitisBMenoresDe1Ano_36() {
        return hepatitisBMenoresDe1Ano_36;
    }

    public void setHepatitisBMenoresDe1Ano_36(String hepatitisBMenoresDe1Ano_36) {
        this.hepatitisBMenoresDe1Ano_36 = hepatitisBMenoresDe1Ano_36;
    }

    public String getPentavelente_37() {
        return pentavelente_37;
    }

    public void setPentavelente_37(String pentavelente_37) {
        this.pentavelente_37 = pentavelente_37;
    }

    public String getPolio_38() {
        return polio_38;
    }

    public void setPolio_38(String polio_38) {
        this.polio_38 = polio_38;
    }

    public String getDptMenoresDe5Anos_39() {
        return dptMenoresDe5Anos_39;
    }

    public void setDptMenoresDe5Anos_39(String dptMenoresDe5Anos_39) {
        this.dptMenoresDe5Anos_39 = dptMenoresDe5Anos_39;
    }

    public String getRotavirus_40() {
        return rotavirus_40;
    }

    public void setRotavirus_40(String rotavirus_40) {
        this.rotavirus_40 = rotavirus_40;
    }

    public String getNeumococo_41() {
        return neumococo_41;
    }

    public void setNeumococo_41(String neumococo_41) {
        this.neumococo_41 = neumococo_41;
    }

    public String getInfluenzaNinos_42() {
        return influenzaNinos_42;
    }

    public void setInfluenzaNinos_42(String influenzaNinos_42) {
        this.influenzaNinos_42 = influenzaNinos_42;
    }

    public String getFiebreAmarillaNinos1Ano_43() {
        return fiebreAmarillaNinos1Ano_43;
    }

    public void setFiebreAmarillaNinos1Ano_43(String fiebreAmarillaNinos1Ano_43) {
        this.fiebreAmarillaNinos1Ano_43 = fiebreAmarillaNinos1Ano_43;
    }

    public String getHepatitisA_44() {
        return hepatitisA_44;
    }

    public void setHepatitisA_44(String hepatitisA_44) {
        this.hepatitisA_44 = hepatitisA_44;
    }

    public String getTripleViralNinos_45() {
        return tripleViralNinos_45;
    }

    public void setTripleViralNinos_45(String tripleViralNinos_45) {
        this.tripleViralNinos_45 = tripleViralNinos_45;
    }

    public String getVirusDelPapilomaHumano_46() {
        return virusDelPapilomaHumano_46;
    }

    public void setVirusDelPapilomaHumano_46(String virusDelPapilomaHumano_46) {
        this.virusDelPapilomaHumano_46 = virusDelPapilomaHumano_46;
    }

    public String getTdOTtMujeresEdadFertil_47() {
        return tdOTtMujeresEdadFertil_47;
    }

    public void setTdOTtMujeresEdadFertil_47(String tdOTtMujeresEdadFertil_47) {
        this.tdOTtMujeresEdadFertil_47 = tdOTtMujeresEdadFertil_47;
    }

    public String getControlDePlacaBacteriana_48() {
        return controlDePlacaBacteriana_48;
    }

    public void setControlDePlacaBacteriana_48(String controlDePlacaBacteriana_48) {
        this.controlDePlacaBacteriana_48 = controlDePlacaBacteriana_48;
    }

    public Date getFechaAtencionPartoOCesarea_49() {
        return fechaAtencionPartoOCesarea_49;
    }

    public void setFechaAtencionPartoOCesarea_49(Date fechaAtencionPartoOCesarea_49) {
        this.fechaAtencionPartoOCesarea_49 = fechaAtencionPartoOCesarea_49;
    }

    public Date getFechaSalidaAtencionPartoOCesarea_50() {
        return fechaSalidaAtencionPartoOCesarea_50;
    }

    public void setFechaSalidaAtencionPartoOCesarea_50(Date fechaSalidaAtencionPartoOCesarea_50) {
        this.fechaSalidaAtencionPartoOCesarea_50 = fechaSalidaAtencionPartoOCesarea_50;
    }

    public String getFechaConsejeriaLactanciaMaterna_51() {
        return fechaConsejeriaLactanciaMaterna_51;
    }

    public void setFechaConsejeriaLactanciaMaterna_51(String fechaConsejeriaLactanciaMaterna_51) {
        this.fechaConsejeriaLactanciaMaterna_51 = fechaConsejeriaLactanciaMaterna_51;
    }

    public String getControlDelRecienNacido_52() {
        return controlDelRecienNacido_52;
    }

    public void setControlDelRecienNacido_52(String controlDelRecienNacido_52) {
        this.controlDelRecienNacido_52 = controlDelRecienNacido_52;
    }

    public String getPlanificacionFaminiarPrimerVez_53() {
        return planificacionFaminiarPrimerVez_53;
    }

    public void setPlanificacionFaminiarPrimerVez_53(String planificacionFaminiarPrimerVez_53) {
        this.planificacionFaminiarPrimerVez_53 = planificacionFaminiarPrimerVez_53;
    }

    public String getSuministroDeMetodoAnticonceptivo_54() {
        return suministroDeMetodoAnticonceptivo_54;
    }

    public void setSuministroDeMetodoAnticonceptivo_54(String suministroDeMetodoAnticonceptivo_54) {
        this.suministroDeMetodoAnticonceptivo_54 = suministroDeMetodoAnticonceptivo_54;
    }

    public String getFechaSuministroMetodoAnticonceptivo_55() {
        return fechaSuministroMetodoAnticonceptivo_55;
    }

    public void setFechaSuministroMetodoAnticonceptivo_55(String fechaSuministroMetodoAnticonceptivo_55) {
        this.fechaSuministroMetodoAnticonceptivo_55 = fechaSuministroMetodoAnticonceptivo_55;
    }

    public String getControlPrenatalPrimeraVez_56() {
        return controlPrenatalPrimeraVez_56;
    }

    public void setControlPrenatalPrimeraVez_56(String controlPrenatalPrimeraVez_56) {
        this.controlPrenatalPrimeraVez_56 = controlPrenatalPrimeraVez_56;
    }

    public String getControlPrenatal_57() {
        return controlPrenatal_57;
    }

    public void setControlPrenatal_57(String controlPrenatal_57) {
        this.controlPrenatal_57 = controlPrenatal_57;
    }

    public String getUltimoControlPrenatal_58() {
        return ultimoControlPrenatal_58;
    }

    public void setUltimoControlPrenatal_58(String ultimoControlPrenatal_58) {
        this.ultimoControlPrenatal_58 = ultimoControlPrenatal_58;
    }

    public String getSuministroDeAcidoFolicoUltimoControlPrenatal_59() {
        return suministroDeAcidoFolicoUltimoControlPrenatal_59;
    }

    public void setSuministroDeAcidoFolicoUltimoControlPrenatal_59(String suministroDeAcidoFolicoUltimoControlPrenatal_59) {
        this.suministroDeAcidoFolicoUltimoControlPrenatal_59 = suministroDeAcidoFolicoUltimoControlPrenatal_59;
    }

    public String getSuministroSulfatoFerrosoUltimoControlPrenatal_60() {
        return suministroSulfatoFerrosoUltimoControlPrenatal_60;
    }

    public void setSuministroSulfatoFerrosoUltimoControlPrenatal_60(String suministroSulfatoFerrosoUltimoControlPrenatal_60) {
        this.suministroSulfatoFerrosoUltimoControlPrenatal_60 = suministroSulfatoFerrosoUltimoControlPrenatal_60;
    }

    public String getSuministroCarbonatoCalcioUltimoControlPrenatal_61() {
        return suministroCarbonatoCalcioUltimoControlPrenatal_61;
    }

    public void setSuministroCarbonatoCalcioUltimoControlPrenatal_61(String suministroCarbonatoCalcioUltimoControlPrenatal_61) {
        this.suministroCarbonatoCalcioUltimoControlPrenatal_61 = suministroCarbonatoCalcioUltimoControlPrenatal_61;
    }

    public Date getValoracionAgudezaVisual_62() {
        return valoracionAgudezaVisual_62;
    }

    public void setValoracionAgudezaVisual_62(Date valoracionAgudezaVisual_62) {
        this.valoracionAgudezaVisual_62 = valoracionAgudezaVisual_62;
    }

    public Date getConsultaPorOftalmologia_63() {
        return consultaPorOftalmologia_63;
    }

    public void setConsultaPorOftalmologia_63(Date consultaPorOftalmologia_63) {
        this.consultaPorOftalmologia_63 = consultaPorOftalmologia_63;
    }

    public Date getFechaDiagnosticoDesnutricionProteicoCalorica_64() {
        return fechaDiagnosticoDesnutricionProteicoCalorica_64;
    }

    public void setFechaDiagnosticoDesnutricionProteicoCalorica_64(Date fechaDiagnosticoDesnutricionProteicoCalorica_64) {
        this.fechaDiagnosticoDesnutricionProteicoCalorica_64 = fechaDiagnosticoDesnutricionProteicoCalorica_64;
    }

    public Date getConsultaMujerOMenorVictimaDeMaltrato_65() {
        return consultaMujerOMenorVictimaDeMaltrato_65;
    }

    public void setConsultaMujerOMenorVictimaDeMaltrato_65(Date consultaMujerOMenorVictimaDeMaltrato_65) {
        this.consultaMujerOMenorVictimaDeMaltrato_65 = consultaMujerOMenorVictimaDeMaltrato_65;
    }

    public Date getConsultaVictimasViolenciaSexual_66() {
        return consultaVictimasViolenciaSexual_66;
    }

    public void setConsultaVictimasViolenciaSexual_66(Date consultaVictimasViolenciaSexual_66) {
        this.consultaVictimasViolenciaSexual_66 = consultaVictimasViolenciaSexual_66;
    }

    public Date getConsultaNutricion_67() {
        return consultaNutricion_67;
    }

    public void setConsultaNutricion_67(Date consultaNutricion_67) {
        this.consultaNutricion_67 = consultaNutricion_67;
    }

    public Date getConsultaPsicologia_68() {
        return consultaPsicologia_68;
    }

    public void setConsultaPsicologia_68(Date consultaPsicologia_68) {
        this.consultaPsicologia_68 = consultaPsicologia_68;
    }

    public Date getConsultaCrecimientoDesarrollo_69() {
        return consultaCrecimientoDesarrollo_69;
    }

    public void setConsultaCrecimientoDesarrollo_69(Date consultaCrecimientoDesarrollo_69) {
        this.consultaCrecimientoDesarrollo_69 = consultaCrecimientoDesarrollo_69;
    }

    public String getSuministroSultafoFerrosoUltimaConsultaMenor10Anos_70() {
        return suministroSultafoFerrosoUltimaConsultaMenor10Anos_70;
    }

    public void setSuministroSultafoFerrosoUltimaConsultaMenor10Anos_70(String suministroSultafoFerrosoUltimaConsultaMenor10Anos_70) {
        this.suministroSultafoFerrosoUltimaConsultaMenor10Anos_70 = suministroSultafoFerrosoUltimaConsultaMenor10Anos_70;
    }

    public String getSuministroVitaminaAUltimaConsultaMenor10Anos_71() {
        return suministroVitaminaAUltimaConsultaMenor10Anos_71;
    }

    public void setSuministroVitaminaAUltimaConsultaMenor10Anos_71(String suministroVitaminaAUltimaConsultaMenor10Anos_71) {
        this.suministroVitaminaAUltimaConsultaMenor10Anos_71 = suministroVitaminaAUltimaConsultaMenor10Anos_71;
    }

    public Date getConsultaJovenOrimeraVez_72() {
        return consultaJovenOrimeraVez_72;
    }

    public void setConsultaJovenOrimeraVez_72(Date consultaJovenOrimeraVez_72) {
        this.consultaJovenOrimeraVez_72 = consultaJovenOrimeraVez_72;
    }

    public Date getConsultaAdultoPrimeraVez_73() {
        return consultaAdultoPrimeraVez_73;
    }

    public void setConsultaAdultoPrimeraVez_73(Date consultaAdultoPrimeraVez_73) {
        this.consultaAdultoPrimeraVez_73 = consultaAdultoPrimeraVez_73;
    }

    public String getPreservativosEntregadosPacienteIts_74() {
        return preservativosEntregadosPacienteIts_74;
    }

    public void setPreservativosEntregadosPacienteIts_74(String preservativosEntregadosPacienteIts_74) {
        this.preservativosEntregadosPacienteIts_74 = preservativosEntregadosPacienteIts_74;
    }

    public Date getAsesoriaPreTestVih_75() {
        return asesoriaPreTestVih_75;
    }

    public void setAsesoriaPreTestVih_75(Date asesoriaPreTestVih_75) {
        this.asesoriaPreTestVih_75 = asesoriaPreTestVih_75;
    }

    public Date getAsesoriaPostTestElisaVih_76() {
        return asesoriaPostTestElisaVih_76;
    }

    public void setAsesoriaPostTestElisaVih_76(Date asesoriaPostTestElisaVih_76) {
        this.asesoriaPostTestElisaVih_76 = asesoriaPostTestElisaVih_76;
    }

    public String getPacienteDiagnosticoUltimos6MesesEquipoInterCompleto_77() {
        return pacienteDiagnosticoUltimos6MesesEquipoInterCompleto_77;
    }

    public void setPacienteDiagnosticoUltimos6MesesEquipoInterCompleto_77(String pacienteDiagnosticoUltimos6MesesEquipoInterCompleto_77) {
        this.pacienteDiagnosticoUltimos6MesesEquipoInterCompleto_77 = pacienteDiagnosticoUltimos6MesesEquipoInterCompleto_77;
    }

    public Date getFechaAntigenoSuperficieHepatitisBenGestantes_78() {
        return fechaAntigenoSuperficieHepatitisBenGestantes_78;
    }

    public void setFechaAntigenoSuperficieHepatitisBenGestantes_78(Date fechaAntigenoSuperficieHepatitisBenGestantes_78) {
        this.fechaAntigenoSuperficieHepatitisBenGestantes_78 = fechaAntigenoSuperficieHepatitisBenGestantes_78;
    }

    public String getResultadoAntigenoSuperficieHepatitisB_79() {
        return resultadoAntigenoSuperficieHepatitisB_79;
    }

    public void setResultadoAntigenoSuperficieHepatitisB_79(String resultadoAntigenoSuperficieHepatitisB_79) {
        this.resultadoAntigenoSuperficieHepatitisB_79 = resultadoAntigenoSuperficieHepatitisB_79;
    }

    public Date getFechaSerologiaSifilis_80() {
        return fechaSerologiaSifilis_80;
    }

    public void setFechaSerologiaSifilis_80(Date fechaSerologiaSifilis_80) {
        this.fechaSerologiaSifilis_80 = fechaSerologiaSifilis_80;
    }

    public String getResultadoSerologíaSífilis_81() {
        return resultadoSerologíaSífilis_81;
    }

    public void setResultadoSerologíaSífilis_81(String resultadoSerologíaSífilis_81) {
        this.resultadoSerologíaSífilis_81 = resultadoSerologíaSífilis_81;
    }

    public Date getFechaTomaElisaVIH_82() {
        return fechaTomaElisaVIH_82;
    }

    public void setFechaTomaElisaVIH_82(Date fechaTomaElisaVIH_82) {
        this.fechaTomaElisaVIH_82 = fechaTomaElisaVIH_82;
    }

    public String getResultadoElisaVIH_83() {
        return resultadoElisaVIH_83;
    }

    public void setResultadoElisaVIH_83(String resultadoElisaVIH_83) {
        this.resultadoElisaVIH_83 = resultadoElisaVIH_83;
    }

    public String getFechaTshNeonatal_84() {
        return fechaTshNeonatal_84;
    }

    public void setFechaTshNeonatal_84(String fechaTshNeonatal_84) {
        this.fechaTshNeonatal_84 = fechaTshNeonatal_84;
    }

    public String getResultadoTshNeonatal_85() {
        return resultadoTshNeonatal_85;
    }

    public void setResultadoTshNeonatal_85(String resultadoTshNeonatal_85) {
        this.resultadoTshNeonatal_85 = resultadoTshNeonatal_85;
    }

    public String getTamizajeCancerCuelloUterino_86() {
        return tamizajeCancerCuelloUterino_86;
    }

    public void setTamizajeCancerCuelloUterino_86(String tamizajeCancerCuelloUterino_86) {
        this.tamizajeCancerCuelloUterino_86 = tamizajeCancerCuelloUterino_86;
    }

    public String getCitologiaCervicoUterina_87() {
        return citologiaCervicoUterina_87;
    }

    public void setCitologiaCervicoUterina_87(String citologiaCervicoUterina_87) {
        this.citologiaCervicoUterina_87 = citologiaCervicoUterina_87;
    }

    public String getCitologiaCervicoUterinaResultadosSegunBethesda_88() {
        return citologiaCervicoUterinaResultadosSegunBethesda_88;
    }

    public void setCitologiaCervicoUterinaResultadosSegunBethesda_88(String citologiaCervicoUterinaResultadosSegunBethesda_88) {
        this.citologiaCervicoUterinaResultadosSegunBethesda_88 = citologiaCervicoUterinaResultadosSegunBethesda_88;
    }

    public String getCalidadEnMuestraCitologiaCervicoUterina_89() {
        return calidadEnMuestraCitologiaCervicoUterina_89;
    }

    public void setCalidadEnMuestraCitologiaCervicoUterina_89(String calidadEnMuestraCitologiaCervicoUterina_89) {
        this.calidadEnMuestraCitologiaCervicoUterina_89 = calidadEnMuestraCitologiaCervicoUterina_89;
    }

    public String getCodigoHabilitacionIpsTomaCitologiaCervicoUterina_90() {
        return codigoHabilitacionIpsTomaCitologiaCervicoUterina_90;
    }

    public void setCodigoHabilitacionIpsTomaCitologiaCervicoUterina_90(String codigoHabilitacionIpsTomaCitologiaCervicoUterina_90) {
        this.codigoHabilitacionIpsTomaCitologiaCervicoUterina_90 = codigoHabilitacionIpsTomaCitologiaCervicoUterina_90;
    }

    public Date getFechaColposcopia_91() {
        return fechaColposcopia_91;
    }

    public void setFechaColposcopia_91(Date fechaColposcopia_91) {
        this.fechaColposcopia_91 = fechaColposcopia_91;
    }

    public String getCodigoHabilitacionIpsTomaColposcopia_92() {
        return codigoHabilitacionIpsTomaColposcopia_92;
    }

    public void setCodigoHabilitacionIpsTomaColposcopia_92(String codigoHabilitacionIpsTomaColposcopia_92) {
        this.codigoHabilitacionIpsTomaColposcopia_92 = codigoHabilitacionIpsTomaColposcopia_92;
    }

    public Date getFechaBiopsiaCervical_93() {
        return fechaBiopsiaCervical_93;
    }

    public void setFechaBiopsiaCervical_93(Date fechaBiopsiaCervical_93) {
        this.fechaBiopsiaCervical_93 = fechaBiopsiaCervical_93;
    }

    public String getResultadoBiopsiaCervical_94() {
        return resultadoBiopsiaCervical_94;
    }

    public void setResultadoBiopsiaCervical_94(String resultadoBiopsiaCervical_94) {
        this.resultadoBiopsiaCervical_94 = resultadoBiopsiaCervical_94;
    }

    public String getCodigoHabilitacionIpsTomaBiopsiaCervical_95() {
        return codigoHabilitacionIpsTomaBiopsiaCervical_95;
    }

    public void setCodigoHabilitacionIpsTomaBiopsiaCervical_95(String codigoHabilitacionIpsTomaBiopsiaCervical_95) {
        this.codigoHabilitacionIpsTomaBiopsiaCervical_95 = codigoHabilitacionIpsTomaBiopsiaCervical_95;
    }

    public Date getFechaDeMamografia_96() {
        return fechaDeMamografia_96;
    }

    public void setFechaDeMamografia_96(Date fechaDeMamografia_96) {
        this.fechaDeMamografia_96 = fechaDeMamografia_96;
    }

    public String getResultadoMamografia_97() {
        return resultadoMamografia_97;
    }

    public void setResultadoMamografia_97(String resultadoMamografia_97) {
        this.resultadoMamografia_97 = resultadoMamografia_97;
    }

    public String getCodigoHabilitacionIpsTomaMamografia_98() {
        return codigoHabilitacionIpsTomaMamografia_98;
    }

    public void setCodigoHabilitacionIpsTomaMamografia_98(String codigoHabilitacionIpsTomaMamografia_98) {
        this.codigoHabilitacionIpsTomaMamografia_98 = codigoHabilitacionIpsTomaMamografia_98;
    }

    public Date getFechaTomaBiopsiaSenoPorBacaf_99() {
        return fechaTomaBiopsiaSenoPorBacaf_99;
    }

    public void setFechaTomaBiopsiaSenoPorBacaf_99(Date fechaTomaBiopsiaSenoPorBacaf_99) {
        this.fechaTomaBiopsiaSenoPorBacaf_99 = fechaTomaBiopsiaSenoPorBacaf_99;
    }

    public Date getFechaResultadoBiopsiaSeno_100() {
        return fechaResultadoBiopsiaSeno_100;
    }

    public void setFechaResultadoBiopsiaSeno_100(Date fechaResultadoBiopsiaSeno_100) {
        this.fechaResultadoBiopsiaSeno_100 = fechaResultadoBiopsiaSeno_100;
    }

    public String getResultadoBiopsiaSeno_101() {
        return resultadoBiopsiaSeno_101;
    }

    public void setResultadoBiopsiaSeno_101(String resultadoBiopsiaSeno_101) {
        this.resultadoBiopsiaSeno_101 = resultadoBiopsiaSeno_101;
    }

    public String getCodigoHabilitacionIpsTomaBiopsiaSeno102() {
        return codigoHabilitacionIpsTomaBiopsiaSeno102;
    }

    public void setCodigoHabilitacionIpsTomaBiopsiaSeno102(String codigoHabilitacionIpsTomaBiopsiaSeno102) {
        this.codigoHabilitacionIpsTomaBiopsiaSeno102 = codigoHabilitacionIpsTomaBiopsiaSeno102;
    }

    public String getFechaTomaHemoglobina_103() {
        return fechaTomaHemoglobina_103;
    }

    public void setFechaTomaHemoglobina_103(String fechaTomaHemoglobina_103) {
        this.fechaTomaHemoglobina_103 = fechaTomaHemoglobina_103;
    }

    public String getHemoglobina_104() {
        return hemoglobina_104;
    }

    public void setHemoglobina_104(String hemoglobina_104) {
        this.hemoglobina_104 = hemoglobina_104;
    }

    public String getFechaTomaGlicemiaBasal_105() {
        return fechaTomaGlicemiaBasal_105;
    }

    public void setFechaTomaGlicemiaBasal_105(String fechaTomaGlicemiaBasal_105) {
        this.fechaTomaGlicemiaBasal_105 = fechaTomaGlicemiaBasal_105;
    }

    public String getFechaCreatinina_106() {
        return fechaCreatinina_106;
    }

    public void setFechaCreatinina_106(String fechaCreatinina_106) {
        this.fechaCreatinina_106 = fechaCreatinina_106;
    }

    public String getCreatinina_107() {
        return Creatinina_107;
    }

    public void setCreatinina_107(String creatinina_107) {
        Creatinina_107 = creatinina_107;
    }

    public Date getFechaHemoglobinaGlicosilada_108() {
        return fechaHemoglobinaGlicosilada_108;
    }

    public void setFechaHemoglobinaGlicosilada_108(Date fechaHemoglobinaGlicosilada_108) {
        this.fechaHemoglobinaGlicosilada_108 = fechaHemoglobinaGlicosilada_108;
    }

    public String getHemoglobinaGlicosilada_109() {
        return hemoglobinaGlicosilada_109;
    }

    public void setHemoglobinaGlicosilada_109(String hemoglobinaGlicosilada_109) {
        this.hemoglobinaGlicosilada_109 = hemoglobinaGlicosilada_109;
    }

    public Date getFechaTomaMicroalbuminuria_110() {
        return fechaTomaMicroalbuminuria_110;
    }

    public void setFechaTomaMicroalbuminuria_110(Date fechaTomaMicroalbuminuria_110) {
        this.fechaTomaMicroalbuminuria_110 = fechaTomaMicroalbuminuria_110;
    }

    public Date getFechaTomaHDL_111() {
        return fechaTomaHDL_111;
    }

    public void setFechaTomaHDL_111(Date fechaTomaHDL_111) {
        this.fechaTomaHDL_111 = fechaTomaHDL_111;
    }

    public Date getFechaTomaBaciloscopiaDiagnostico_112() {
        return fechaTomaBaciloscopiaDiagnostico_112;
    }

    public void setFechaTomaBaciloscopiaDiagnostico_112(Date fechaTomaBaciloscopiaDiagnostico_112) {
        this.fechaTomaBaciloscopiaDiagnostico_112 = fechaTomaBaciloscopiaDiagnostico_112;
    }

    public String getBaciloscopiaDiagnostico_113() {
        return baciloscopiaDiagnostico_113;
    }

    public void setBaciloscopiaDiagnostico_113(String baciloscopiaDiagnostico_113) {
        this.baciloscopiaDiagnostico_113 = baciloscopiaDiagnostico_113;
    }

    public String getTratamientoHipotiroidismoCongenito_114() {
        return tratamientoHipotiroidismoCongenito_114;
    }

    public void setTratamientoHipotiroidismoCongenito_114(String tratamientoHipotiroidismoCongenito_114) {
        this.tratamientoHipotiroidismoCongenito_114 = tratamientoHipotiroidismoCongenito_114;
    }

    public String getTratamientoSifilisGestacional_115() {
        return tratamientoSifilisGestacional_115;
    }

    public void setTratamientoSifilisGestacional_115(String tratamientoSifilisGestacional_115) {
        this.tratamientoSifilisGestacional_115 = tratamientoSifilisGestacional_115;
    }

    public String getTratamientoSifilisCongenita_116() {
        return tratamientoSifilisCongenita_116;
    }

    public void setTratamientoSifilisCongenita_116(String tratamientoSifilisCongenita_116) {
        this.tratamientoSifilisCongenita_116 = tratamientoSifilisCongenita_116;
    }

    public String getTratamientoLepra_117() {
        return tratamientoLepra_117;
    }

    public void setTratamientoLepra_117(String tratamientoLepra_117) {
        this.tratamientoLepra_117 = tratamientoLepra_117;
    }

    public Date getFechaTerminacionTratamientoLeishmaniasis_118() {
        return fechaTerminacionTratamientoLeishmaniasis_118;
    }

    public void setFechaTerminacionTratamientoLeishmaniasis_118(Date fechaTerminacionTratamientoLeishmaniasis_118) {
        this.fechaTerminacionTratamientoLeishmaniasis_118 = fechaTerminacionTratamientoLeishmaniasis_118;
    }

    @Override
    public String toString() {
        return "VariablesControlDto{" +
                "gestacion_14='" + gestacion_14 + '\'' +
                ", sifilisGestacionalOCongenita_15='" + sifilisGestacionalOCongenita_15 + '\'' +
                ", hipertencionInducidaPorLaGestacion_16='" + hipertencionInducidaPorLaGestacion_16 + '\'' +
                ", hipotiroidismoCongenito_17='" + hipotiroidismoCongenito_17 + '\'' +
                ", sintomaticoRespiratorio_18='" + sintomaticoRespiratorio_18 + '\'' +
                ", tbcMultidrogoresistente_19='" + tbcMultidrogoresistente_19 + '\'' +
                ", lepra_20='" + lepra_20 + '\'' +
                ", obesidadODesnutricionProteicoCalorica_21='" + obesidadODesnutricionProteicoCalorica_21 + '\'' +
                ", victimaDeMaltrato_22='" + victimaDeMaltrato_22 + '\'' +
                ", victimasDeViolenciaSexual_23='" + victimasDeViolenciaSexual_23 + '\'' +
                ", infeccionesDeTransmisionSexual_24='" + infeccionesDeTransmisionSexual_24 + '\'' +
                ", enfermedadMental_25='" + enfermedadMental_25 + '\'' +
                ", cancerDeCervix_26='" + cancerDeCervix_26 + '\'' +
                ", cancerDeSeno_27='" + cancerDeSeno_27 + '\'' +
                ", fluorosisDental_28='" + fluorosisDental_28 + '\'' +
                ", fechaDelPeso_29=" + fechaDelPeso_29 +
                ", pesoEnKg_30=" + pesoEnKg_30 +
                ", fechaDeLaTalla_31=" + fechaDeLaTalla_31 +
                ", tallaEnCm_32=" + tallaEnCm_32 +
                ", fechaProbableDelParto_33='" + fechaProbableDelParto_33 + '\'' +
                ", edadGestacionalAlNacer_34='" + edadGestacionalAlNacer_34 + '\'' +
                ", bcg_35='" + bcg_35 + '\'' +
                ", hepatitisBMenoresDe1Ano_36='" + hepatitisBMenoresDe1Ano_36 + '\'' +
                ", pentavelente_37='" + pentavelente_37 + '\'' +
                ", polio_38='" + polio_38 + '\'' +
                ", dptMenoresDe5Anos_39='" + dptMenoresDe5Anos_39 + '\'' +
                ", rotavirus_40='" + rotavirus_40 + '\'' +
                ", neumococo_41='" + neumococo_41 + '\'' +
                ", influenzaNinos_42='" + influenzaNinos_42 + '\'' +
                ", fiebreAmarillaNinos1Ano_43='" + fiebreAmarillaNinos1Ano_43 + '\'' +
                ", hepatitisA_44='" + hepatitisA_44 + '\'' +
                ", tripleViralNinos_45='" + tripleViralNinos_45 + '\'' +
                ", virusDelPapilomaHumano_46='" + virusDelPapilomaHumano_46 + '\'' +
                ", tdOTtMujeresEdadFertil_47='" + tdOTtMujeresEdadFertil_47 + '\'' +
                ", controlDePlacaBacteriana_48='" + controlDePlacaBacteriana_48 + '\'' +
                ", fechaAtencionPartoOCesarea_49=" + fechaAtencionPartoOCesarea_49 +
                ", fechaSalidaAtencionPartoOCesarea_50=" + fechaSalidaAtencionPartoOCesarea_50 +
                ", fechaConsejeriaLactanciaMaterna_51='" + fechaConsejeriaLactanciaMaterna_51 + '\'' +
                ", controlDelRecienNacido_52='" + controlDelRecienNacido_52 + '\'' +
                ", planificacionFaminiarPrimerVez_53='" + planificacionFaminiarPrimerVez_53 + '\'' +
                ", suministroDeMetodoAnticonceptivo_54='" + suministroDeMetodoAnticonceptivo_54 + '\'' +
                ", fechaSuministroMetodoAnticonceptivo_55='" + fechaSuministroMetodoAnticonceptivo_55 + '\'' +
                ", controlPrenatalPrimeraVez_56='" + controlPrenatalPrimeraVez_56 + '\'' +
                ", controlPrenatal_57='" + controlPrenatal_57 + '\'' +
                ", ultimoControlPrenatal_58='" + ultimoControlPrenatal_58 + '\'' +
                ", suministroDeAcidoFolicoUltimoControlPrenatal_59='" + suministroDeAcidoFolicoUltimoControlPrenatal_59 + '\'' +
                ", suministroSulfatoFerrosoUltimoControlPrenatal_60='" + suministroSulfatoFerrosoUltimoControlPrenatal_60 + '\'' +
                ", suministroCarbonatoCalcioUltimoControlPrenatal_61='" + suministroCarbonatoCalcioUltimoControlPrenatal_61 + '\'' +
                ", valoracionAgudezaVisual_62=" + valoracionAgudezaVisual_62 +
                ", consultaPorOftalmologia_63=" + consultaPorOftalmologia_63 +
                ", fechaDiagnosticoDesnutricionProteicoCalorica_64=" + fechaDiagnosticoDesnutricionProteicoCalorica_64 +
                ", consultaMujerOMenorVictimaDeMaltrato_65=" + consultaMujerOMenorVictimaDeMaltrato_65 +
                ", consultaVictimasViolenciaSexual_66=" + consultaVictimasViolenciaSexual_66 +
                ", consultaNutricion_67=" + consultaNutricion_67 +
                ", consultaPsicologia_68=" + consultaPsicologia_68 +
                ", consultaCrecimientoDesarrollo_69=" + consultaCrecimientoDesarrollo_69 +
                ", suministroSultafoFerrosoUltimaConsultaMenor10Anos_70='" + suministroSultafoFerrosoUltimaConsultaMenor10Anos_70 + '\'' +
                ", suministroVitaminaAUltimaConsultaMenor10Anos_71='" + suministroVitaminaAUltimaConsultaMenor10Anos_71 + '\'' +
                ", consultaJovenOrimeraVez_72=" + consultaJovenOrimeraVez_72 +
                ", consultaAdultoPrimeraVez_73=" + consultaAdultoPrimeraVez_73 +
                ", preservativosEntregadosPacienteIts_74='" + preservativosEntregadosPacienteIts_74 + '\'' +
                ", asesoriaPreTestVih_75=" + asesoriaPreTestVih_75 +
                ", asesoriaPostTestElisaVih_76=" + asesoriaPostTestElisaVih_76 +
                ", pacienteDiagnosticoUltimos6MesesEquipoInterCompleto_77='" + pacienteDiagnosticoUltimos6MesesEquipoInterCompleto_77 + '\'' +
                ", fechaAntigenoSuperficieHepatitisBenGestantes_78=" + fechaAntigenoSuperficieHepatitisBenGestantes_78 +
                ", resultadoAntigenoSuperficieHepatitisB_79='" + resultadoAntigenoSuperficieHepatitisB_79 + '\'' +
                ", fechaSerologiaSifilis_80=" + fechaSerologiaSifilis_80 +
                ", resultadoSerologíaSífilis_81='" + resultadoSerologíaSífilis_81 + '\'' +
                ", fechaTomaElisaVIH_82=" + fechaTomaElisaVIH_82 +
                ", resultadoElisaVIH_83='" + resultadoElisaVIH_83 + '\'' +
                ", fechaTshNeonatal_84='" + fechaTshNeonatal_84 + '\'' +
                ", resultadoTshNeonatal_85='" + resultadoTshNeonatal_85 + '\'' +
                ", tamizajeCancerCuelloUterino_86='" + tamizajeCancerCuelloUterino_86 + '\'' +
                ", citologiaCervicoUterina_87='" + citologiaCervicoUterina_87 + '\'' +
                ", citologiaCervicoUterinaResultadosSegunBethesda_88='" + citologiaCervicoUterinaResultadosSegunBethesda_88 + '\'' +
                ", calidadEnMuestraCitologiaCervicoUterina_89='" + calidadEnMuestraCitologiaCervicoUterina_89 + '\'' +
                ", codigoHabilitacionIpsTomaCitologiaCervicoUterina_90='" + codigoHabilitacionIpsTomaCitologiaCervicoUterina_90 + '\'' +
                ", fechaColposcopia_91=" + fechaColposcopia_91 +
                ", codigoHabilitacionIpsTomaColposcopia_92='" + codigoHabilitacionIpsTomaColposcopia_92 + '\'' +
                ", fechaBiopsiaCervical_93=" + fechaBiopsiaCervical_93 +
                ", resultadoBiopsiaCervical_94='" + resultadoBiopsiaCervical_94 + '\'' +
                ", codigoHabilitacionIpsTomaBiopsiaCervical_95='" + codigoHabilitacionIpsTomaBiopsiaCervical_95 + '\'' +
                ", fechaDeMamografia_96=" + fechaDeMamografia_96 +
                ", resultadoMamografia_97='" + resultadoMamografia_97 + '\'' +
                ", codigoHabilitacionIpsTomaMamografia_98='" + codigoHabilitacionIpsTomaMamografia_98 + '\'' +
                ", fechaTomaBiopsiaSenoPorBacaf_99=" + fechaTomaBiopsiaSenoPorBacaf_99 +
                ", fechaResultadoBiopsiaSeno_100=" + fechaResultadoBiopsiaSeno_100 +
                ", resultadoBiopsiaSeno_101='" + resultadoBiopsiaSeno_101 + '\'' +
                ", codigoHabilitacionIpsTomaBiopsiaSeno102='" + codigoHabilitacionIpsTomaBiopsiaSeno102 + '\'' +
                ", fechaTomaHemoglobina_103='" + fechaTomaHemoglobina_103 + '\'' +
                ", hemoglobina_104='" + hemoglobina_104 + '\'' +
                ", fechaTomaGlicemiaBasal_105='" + fechaTomaGlicemiaBasal_105 + '\'' +
                ", fechaCreatinina_106='" + fechaCreatinina_106 + '\'' +
                ", Creatinina_107='" + Creatinina_107 + '\'' +
                ", fechaHemoglobinaGlicosilada_108=" + fechaHemoglobinaGlicosilada_108 +
                ", hemoglobinaGlicosilada_109='" + hemoglobinaGlicosilada_109 + '\'' +
                ", fechaTomaMicroalbuminuria_110=" + fechaTomaMicroalbuminuria_110 +
                ", fechaTomaHDL_111=" + fechaTomaHDL_111 +
                ", fechaTomaBaciloscopiaDiagnostico_112=" + fechaTomaBaciloscopiaDiagnostico_112 +
                ", baciloscopiaDiagnostico_113='" + baciloscopiaDiagnostico_113 + '\'' +
                ", tratamientoHipotiroidismoCongenito_114='" + tratamientoHipotiroidismoCongenito_114 + '\'' +
                ", tratamientoSifilisGestacional_115='" + tratamientoSifilisGestacional_115 + '\'' +
                ", tratamientoSifilisCongenita_116='" + tratamientoSifilisCongenita_116 + '\'' +
                ", tratamientoLepra_117='" + tratamientoLepra_117 + '\'' +
                ", fechaTerminacionTratamientoLeishmaniasis_118=" + fechaTerminacionTratamientoLeishmaniasis_118 +
                '}';
    }
}
