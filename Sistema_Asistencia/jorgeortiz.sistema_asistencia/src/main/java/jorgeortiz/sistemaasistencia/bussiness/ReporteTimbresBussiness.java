package jorgeortiz.sistemaasistencia.bussiness;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import jorgeortiz.sistemaasistencia.dao.BiomDepartDAO;
import jorgeortiz.sistemaasistencia.dao.BiomPersDAO;
import jorgeortiz.sistemaasistencia.dao.MainReporteDAO;
import jorgeortiz.sistemaasistencia.fulltime.model.BiometricoDepartamentoSQL;
import jorgeortiz.sistemaasistencia.fulltime.model.BiometricoPersonaSQL;
import jorgeortiz.sistemaasistencia.fulltime.model.EMPLEADO;
import jorgeortiz.sistemaasistencia.nomina.model.ACC_PER;
import jorgeortiz.sistemaasistencia.util.FormatterDate;

@Stateless
public class ReporteTimbresBussiness {
	
	@Inject
	private MainReporteDAO mdao;
	
	private BiomPersDAO bpDAO = new BiomPersDAO();
	
	@Inject
	private BiomDepartDAO bdDAO;
	
	public List<BiometricoPersonaSQL> getBiometricoPersonas(String codigoBiometrico, Date fechaDesde, Date fechaHasta) throws Exception{
		
		String fd = FormatterDate.formatearFecha(fechaDesde);
		String fh = FormatterDate.formatearFecha(fechaHasta);
		
		List<BiometricoPersonaSQL> biometricoPersonas = bpDAO.getBiometricoPersonas(codigoBiometrico, fd, fh);
		
		if(!(biometricoPersonas == null)) {
			return biometricoPersonas;
		}else
			throw new Exception("No hay datos");
				
				
	}
	
	public List<BiometricoDepartamentoSQL> getFechaDepartamentos(Date fechaDesde, Date fechaHasta) throws Exception{
		String fd = FormatterDate.formatearFecha(fechaDesde);
		String fh = FormatterDate.formatearFecha(fechaHasta);
		List<BiometricoDepartamentoSQL> items = bdDAO.getFechaDepartamentos(fd, fh);
		if(!(items.isEmpty())) {
			return items;
		}else
			throw new Exception("No hay datos de Biometrico Departamento");
		
	}
	
	
	public List<BiometricoDepartamentoSQL> getBiometricoDepartamentos(int codigoDepartamento, Date fechaDesde, Date fechaHasta) throws Exception{
		
		String fd = FormatterDate.formatearFecha(fechaDesde);
		String fh = FormatterDate.formatearFecha(fechaHasta);
		
		List<BiometricoDepartamentoSQL> biometricoDepartamento = bdDAO.getBiometricoDepartamentos(codigoDepartamento, fd, fh);
		
		if(!(biometricoDepartamento == null)) {
			return biometricoDepartamento;
		}else
			throw new Exception("No hay datos");
				
				
	}
	
	public List<EMPLEADO> getEmpleados() throws Exception{
		List<EMPLEADO> empleados = mdao.getEmpleados();
		
		if(!(empleados == null)) {
			return empleados;
		}else
			throw new Exception("No hay datos de empleados");
	}
	

}
