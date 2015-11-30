package relatorio;

import java.sql.Connection;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioUtil {

	public void viewReport(String pathRelatorio, Connection con,
			Map<String, Object> parametros) {
		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(pathRelatorio, parametros, con);
			JasperViewer.viewReport(jasperPrint);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	public void gerarPdf(String pathRelatorio, Connection con, Map<String, Object> parametros) {
		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(pathRelatorio, parametros, con);

			JasperExportManager.exportReportToPdfFile(jasperPrint, "relatorio.pdf");
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}
