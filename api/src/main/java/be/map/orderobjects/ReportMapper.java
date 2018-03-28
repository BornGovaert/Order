package be.map.orderobjects;

import be.map.Order.Report;

public class ReportMapper {

    public static ReportDto reportToDto(Report reportToMap) {
        return new ReportDto()
                .withCustomer(reportToMap.getCustomer())
                .withOrdersOfCustomer(reportToMap.getOrdersOfCustomer())
                .withTotalPriceOfAllOrders(reportToMap.getTotalPriceAllOrders());
    }

    public static Report dtoToReport(ReportDto report) {
        return new Report(report.customer, report.ordersOfCustomer, report.totalPriceAllOrders);
    }



}
