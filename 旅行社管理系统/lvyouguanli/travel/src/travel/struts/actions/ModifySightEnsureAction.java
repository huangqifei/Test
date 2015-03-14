package travel.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import travel.struts.data.Sight;
import travel.struts.datemanager.SightManager;

public class ModifySightEnsureAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int sightId = Integer.parseInt(request.getParameter("id"));
		Sight sight = new Sight();
		BeanUtils.copyProperties(sight, form);
		sight.setId(sightId);
		SightManager.getInstance().updateSightInfo(sight);
		return mapping.findForward("success");
	}

}
