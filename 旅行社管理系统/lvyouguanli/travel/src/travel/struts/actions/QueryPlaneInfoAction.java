package travel.struts.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.actionforms.PlaneActionForm;
import travel.struts.data.Plane;
import travel.struts.datemanager.PlaneManager;

public class QueryPlaneInfoAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Plane plane = new Plane();
		BeanUtils.copyProperties(plane, form);
		String number = plane.getNumber();
		String from = plane.getFromcity();
		
		List planeList = new ArrayList();
		List planeList1 = new ArrayList();
		List planeList2 = new ArrayList();
		planeList1 = null;
		planeList2 = null;
		if(number != "") {
			planeList1 = PlaneManager.getInstance().listPlaneByNumber(number);
		}
		if(from != "") {
			planeList2 = PlaneManager.getInstance().listPlaneByFrom(from);
		}
		if(planeList1 == null && planeList2 == null) {
			planeList = null;
		} else if(planeList1 != null && planeList2 == null) {
			planeList = planeList1;
		} else if(planeList1 == null && planeList2 != null) {
			planeList = planeList2;
		} else if(planeList1 != null && planeList2 != null) {
			Iterator it1 = planeList1.iterator();
			Plane p1 = new Plane();
			Plane p2 = new Plane();
			while(it1.hasNext()) {
				p1 = (Plane)it1.next();
				Iterator it2 = planeList2.iterator();
				while(it2.hasNext()) {
					p2 = (Plane)it2.next();
					if(p1.getId() == p2.getId()) {
						planeList.add(p2);
					}
				}
			}
		}
		request.setAttribute("planeList", planeList);
		return mapping.findForward("success");
	}
}
