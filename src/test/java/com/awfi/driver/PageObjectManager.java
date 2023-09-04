package com.awfi.driver;

import org.openqa.selenium.WebDriver;

import com.awfi.pages.AWFILoginPage;
import com.awfi.pages.DashboardPage;
import com.awfi.pages.EquipmentAndMaterialPage;
import com.awfi.pages.FormulasPage;
import com.awfi.pages.GroupPage;
import com.awfi.pages.MyWorkPage;
import com.awfi.pages.NewUserPage;
import com.awfi.pages.ProcessSchedulePage;
import com.awfi.pages.ProcessStepPage;
import com.awfi.pages.ReportsPage;
import com.awfi.pages.UsersPage;
import com.awfi.pages.WorkInstructionPage;

public class PageObjectManager {
	private WebDriver driver;
	private AWFILoginPage loginPage;
	private GroupPage groupPage;
	private UsersPage userPage;
	private NewUserPage newUserPage;
	private EquipmentAndMaterialPage equipmentMaterialPage;
	private ReportsPage reportpage;
	private FormulasPage formula;
	private ProcessStepPage processstep;
	private ProcessSchedulePage processshedulestep;
	private DashboardPage dashboard;
	private MyWorkPage mywork;
	private WorkInstructionPage workinstruction;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public AWFILoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new AWFILoginPage(driver) : loginPage;
	}

	public GroupPage getGroupPage() {
		return (groupPage == null) ? groupPage = new GroupPage(driver) : groupPage;
	}


	public UsersPage getUsersPage() {
		return (userPage == null) ? userPage = new UsersPage(driver) : userPage;
	}

	public NewUserPage getNewUserPage() {
		return (newUserPage == null) ? newUserPage = new NewUserPage(driver) : newUserPage;
	}

	public EquipmentAndMaterialPage getEquipmentAndMaterialPage() {
		return (equipmentMaterialPage == null) ? equipmentMaterialPage = new EquipmentAndMaterialPage(driver)
				: equipmentMaterialPage;
	}

	public ReportsPage getReportsPage() {
		return (reportpage == null) ? reportpage = new ReportsPage(driver) : reportpage;
	}

	public FormulasPage getFormulasPage() {
		return (formula == null) ? formula = new FormulasPage(driver) : formula;
	}

	public ProcessStepPage getProcessStepsPage() {
		return (processstep == null) ? processstep = new ProcessStepPage(driver) : processstep;
	}

	public ProcessSchedulePage getProcessSchedulePage() {
		return (processshedulestep == null) ? processshedulestep = new ProcessSchedulePage(driver) : processshedulestep;
	}

	public DashboardPage getDashboardPage() {
		return (dashboard == null) ? dashboard = new DashboardPage(driver) : dashboard;
	}
	public WorkInstructionPage getWorkInstructionPage() {
		return (workinstruction == null) ? workinstruction = new WorkInstructionPage(driver) : workinstruction;
	}

	public MyWorkPage getMyWorkPage() {
		return (mywork == null) ? mywork = new MyWorkPage(driver) : mywork;
	}
}

