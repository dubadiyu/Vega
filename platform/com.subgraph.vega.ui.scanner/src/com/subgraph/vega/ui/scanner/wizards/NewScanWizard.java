/*******************************************************************************
 * Copyright (c) 2011 Subgraph.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Subgraph - initial API and implementation
 ******************************************************************************/
package com.subgraph.vega.ui.scanner.wizards;

import java.util.Collection;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;

import com.subgraph.vega.api.model.IModel;
import com.subgraph.vega.api.model.identity.IIdentity;
import com.subgraph.vega.api.model.scope.ITargetScope;
import com.subgraph.vega.api.scanner.modules.IScannerModule;
import com.subgraph.vega.ui.scanner.Activator;
import com.subgraph.vega.ui.util.images.ImageCache;

public class NewScanWizard extends Wizard {
	private final static String VEGA_LOGO = "icons/vega_small.png";
	
	private final ImageCache imageCache;
	private NewScanTargetPage targetPage;
	private NewScanModulesPage modulesPage;
	private NewScanAuthPage authPage;
	//private NewScanWizardPage page1;
	//private NewScanWizardPage2 page2;
	//private URI scanHostURI;
	private ITargetScope scanTargetScope;
	//private String validTargetField;
	//private boolean isDomTest;
	private IIdentity scanIdentity;
	private List<String> cookieStringList;
	private String targetFieldString;
	//private List<String> exclusions;

	public NewScanWizard(String target, Collection<IIdentity> identities, List<IScannerModule> modules) {
		final IModel model = Activator.getDefault().getModel();
		imageCache = new ImageCache(Activator.PLUGIN_ID);
		final ImageDescriptor logo = ImageDescriptor.createFromImage(imageCache.get(VEGA_LOGO));
		
		targetPage = new NewScanTargetPage(model.getCurrentWorkspace(), target);
		targetPage.setImageDescriptor(logo);
		
		modulesPage = new NewScanModulesPage(modules);
		modulesPage.setImageDescriptor(logo);
		
		authPage = new NewScanAuthPage(identities);
		authPage.setImageDescriptor(logo);
		
		//page1 = new NewScanWizardPage(imageCache, target, identities, modules);
		
		//page2 = new NewScanWizardPage2(imageCache);
	}
	
	@Override
	public void addPages() {
		addPage(targetPage);
		addPage(modulesPage);
		addPage(authPage);
		//addPage(page1);
		//addPage(page2);
	}
	
	@Override 
	public boolean canFinish() {
		return targetPage.isTargetValid();
		/*
		final String scanHostText = page1.getScanTarget().trim();
		if(scanHostText.isEmpty()) {
			page1.setErrorMessage(null);
			return false;
		}

		final URI target = createTargetURI(scanHostText);
		if(target == null) {
			page1.setErrorMessage("Target entered is not a valid host or URL");
			return false;
		} else {
			page1.setErrorMessage(null);
			return true;
		}
		*/
	}
	
	@Override
	public boolean performFinish() {
		/*
		String target = page1.getScanTarget();
		if (target.equals("domtest")) {
			isDomTest = true;
			return true;
		}
		
		scanIdentity = page1.getScanIdentity();
		cookieStringList = page2.getCookieStringList();
		exclusions = page2.getExclusions();

		scanHostURI = createTargetURI(target);
		if (scanHostURI != null) {
			validTargetField = target;
		}

		return (scanHostURI != null);
		*/
		
		scanIdentity = authPage.getScanIdentity();
		cookieStringList = authPage.getCookieStringList();
		scanTargetScope = targetPage.getScanTargetScope();
		targetFieldString = targetPage.getUriTextIfValid();
		return scanTargetScope != null;
	}

	@Override
	public void dispose() {
		imageCache.dispose();
		super.dispose();
	}
	
	//public URI getScanHostURI() {
		//return scanHostURI;
	//}
	
	public ITargetScope getScanTargetScope() {
		return scanTargetScope;
	}

	public String getTargetField() {
		return targetFieldString;
	}
	
	public List<String> getCookieStringList() {
		return cookieStringList;
	}

	//public boolean isDomTest() {
//		return isDomTest;	
//	}

	public IIdentity getScanIdentity() { 
		return scanIdentity;
	}
	
//	public List<String> getExclusions() {
//		return exclusions;
//	}
	/*
	URI createTargetURI(String value) {
		if (!(value.startsWith("http://") || value.startsWith("https://"))) {
			value = "http://" + value;
		}
		try {
			return new URI(value);
		} catch (URISyntaxException e) {
			return null;
		}
	}
	*/

}
