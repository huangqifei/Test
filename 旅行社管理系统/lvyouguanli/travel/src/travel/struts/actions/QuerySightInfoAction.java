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

import travel.struts.data.Sight;
import travel.struts.datemanager.SightManager;

public class QuerySightInfoAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Sight sight = new Sight();
		BeanUtils.copyProperties(sight, form);
		String sightName = sight.getName();
		String cityName = sight.getCity();
		List sightList = new ArrayList();
		if(sightName == "" && cityName != "") {
			sightList = SightManager.getInstance().listSightByCityName(cityName);
		} else if(sightName != "" && cityName == "") {
			sightList = SightManager.getInstance().listSightBySightName(sightName);
		} else if(sightName != "" && cityName != "") {
			List list1 = SightManager.getInstance().listSightBySightName(sightName);
			List list2 = SightManager.getInstance().listSightByCityName(cityName);
			Iterator it1 = list1.iterator();
			while(it1.hasNext()) {
				Sight s1 = (Sight)it1.next();
				Iterator it2 = list2.iterator();
				while(it2.hasNext()) {
					Sight s2 = (Sight)it2.next();
					if(s1.getId() == s2.getId()) {
						sightList.add(s1);
					}
				}
			}
		} else {
			sightList = null;
		}
		request.setAttribute("sight", sightList);
		return mapping.findForward("success");
	}
}
