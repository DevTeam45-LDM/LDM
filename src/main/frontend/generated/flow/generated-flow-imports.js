import { injectGlobalCss } from 'Frontend/generated/jar-resources/theme-util.js';

import { css, unsafeCSS, registerStyles } from '@vaadin/vaadin-themable-mixin';
import $cssFromFile_0 from 'Frontend/generated/jar-resources/styles.css?inline';
import $cssFromFile_1 from 'Frontend/generated/jar-resources/ckeditor.css?inline';
import 'Frontend/generated/jar-resources/flow-component-renderer.js';
import '@vaadin/polymer-legacy-adapter/style-modules.js';
import '@vaadin/combo-box/theme/lumo/vaadin-combo-box.js';
import 'Frontend/generated/jar-resources/comboBoxConnector.js';
import 'Frontend/generated/jar-resources/vaadin-grid-flow-selection-column.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-column.js';
import '@vaadin/tooltip/theme/lumo/vaadin-tooltip.js';
import '@vaadin/tabs/theme/lumo/vaadin-tab.js';
import '@vaadin/progress-bar/theme/lumo/vaadin-progress-bar.js';
import '@vaadin/button/theme/lumo/vaadin-button.js';
import 'Frontend/generated/jar-resources/buttonFunctions.js';
import 'Frontend/generated/jar-resources/menubarConnector.js';
import '@vaadin/menu-bar/theme/lumo/vaadin-menu-bar.js';
import '@vaadin/dialog/theme/lumo/vaadin-dialog.js';
import '@vaadin/vertical-layout/theme/lumo/vaadin-vertical-layout.js';
import '@vaadin/horizontal-layout/theme/lumo/vaadin-horizontal-layout.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-column-group.js';
import '@vaadin/password-field/theme/lumo/vaadin-password-field.js';
import '@vaadin/upload/theme/lumo/vaadin-upload.js';
import '@vaadin/context-menu/theme/lumo/vaadin-context-menu.js';
import 'Frontend/generated/jar-resources/contextMenuConnector.js';
import 'Frontend/generated/jar-resources/contextMenuTargetConnector.js';
import '@vaadin/multi-select-combo-box/theme/lumo/vaadin-multi-select-combo-box.js';
import '@vaadin/grid/theme/lumo/vaadin-grid.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-sorter.js';
import '@vaadin/checkbox/theme/lumo/vaadin-checkbox.js';
import 'Frontend/generated/jar-resources/gridConnector.ts';
import '@vaadin/text-field/theme/lumo/vaadin-text-field.js';
import 'Frontend/generated/jar-resources/vaadin-ckeditor-utils.min.js';
import 'Frontend/generated/jar-resources/vaadin-ckeditor.min.js';
import 'Frontend/generated/jar-resources/translations/af.js';
import 'Frontend/generated/jar-resources/translations/ar.js';
import 'Frontend/generated/jar-resources/translations/ast.js';
import 'Frontend/generated/jar-resources/translations/az.js';
import 'Frontend/generated/jar-resources/translations/bg.js';
import 'Frontend/generated/jar-resources/translations/bn.js';
import 'Frontend/generated/jar-resources/translations/bs.js';
import 'Frontend/generated/jar-resources/translations/ca.js';
import 'Frontend/generated/jar-resources/translations/cs.js';
import 'Frontend/generated/jar-resources/translations/da.js';
import 'Frontend/generated/jar-resources/translations/de.js';
import 'Frontend/generated/jar-resources/translations/de-ch.js';
import 'Frontend/generated/jar-resources/translations/el.js';
import 'Frontend/generated/jar-resources/translations/en-au.js';
import 'Frontend/generated/jar-resources/translations/en-gb.js';
import 'Frontend/generated/jar-resources/translations/eo.js';
import 'Frontend/generated/jar-resources/translations/es.js';
import 'Frontend/generated/jar-resources/translations/es-co.js';
import 'Frontend/generated/jar-resources/translations/et.js';
import 'Frontend/generated/jar-resources/translations/eu.js';
import 'Frontend/generated/jar-resources/translations/fa.js';
import 'Frontend/generated/jar-resources/translations/fi.js';
import 'Frontend/generated/jar-resources/translations/fr.js';
import 'Frontend/generated/jar-resources/translations/gl.js';
import 'Frontend/generated/jar-resources/translations/gu.js';
import 'Frontend/generated/jar-resources/translations/hi.js';
import 'Frontend/generated/jar-resources/translations/he.js';
import 'Frontend/generated/jar-resources/translations/hr.js';
import 'Frontend/generated/jar-resources/translations/hu.js';
import 'Frontend/generated/jar-resources/translations/id.js';
import 'Frontend/generated/jar-resources/translations/it.js';
import 'Frontend/generated/jar-resources/translations/ja.js';
import 'Frontend/generated/jar-resources/translations/jv.js';
import 'Frontend/generated/jar-resources/translations/km.js';
import 'Frontend/generated/jar-resources/translations/kn.js';
import 'Frontend/generated/jar-resources/translations/ko.js';
import 'Frontend/generated/jar-resources/translations/ku.js';
import 'Frontend/generated/jar-resources/translations/lt.js';
import 'Frontend/generated/jar-resources/translations/lv.js';
import 'Frontend/generated/jar-resources/translations/ms.js';
import 'Frontend/generated/jar-resources/translations/nb.js';
import 'Frontend/generated/jar-resources/translations/ne.js';
import 'Frontend/generated/jar-resources/translations/nl.js';
import 'Frontend/generated/jar-resources/translations/no.js';
import 'Frontend/generated/jar-resources/translations/oc.js';
import 'Frontend/generated/jar-resources/translations/pl.js';
import 'Frontend/generated/jar-resources/translations/pt.js';
import 'Frontend/generated/jar-resources/translations/pt-br.js';
import 'Frontend/generated/jar-resources/translations/ro.js';
import 'Frontend/generated/jar-resources/translations/ru.js';
import 'Frontend/generated/jar-resources/translations/si.js';
import 'Frontend/generated/jar-resources/translations/sk.js';
import 'Frontend/generated/jar-resources/translations/sl.js';
import 'Frontend/generated/jar-resources/translations/sq.js';
import 'Frontend/generated/jar-resources/translations/sr.js';
import 'Frontend/generated/jar-resources/translations/sr-latn.js';
import 'Frontend/generated/jar-resources/translations/sv.js';
import 'Frontend/generated/jar-resources/translations/th.js';
import 'Frontend/generated/jar-resources/translations/tk.js';
import 'Frontend/generated/jar-resources/translations/tr.js';
import 'Frontend/generated/jar-resources/translations/tt.js';
import 'Frontend/generated/jar-resources/translations/ug.js';
import 'Frontend/generated/jar-resources/translations/uz.js';
import 'Frontend/generated/jar-resources/translations/uk.js';
import 'Frontend/generated/jar-resources/translations/ur.js';
import 'Frontend/generated/jar-resources/translations/vi.js';
import 'Frontend/generated/jar-resources/translations/zh.js';
import 'Frontend/generated/jar-resources/translations/zh-cn.js';
import '@vaadin/tabsheet/theme/lumo/vaadin-tabsheet.js';
import '@vaadin/tabs/theme/lumo/vaadin-tabs.js';
import '@vaadin/custom-field/theme/lumo/vaadin-custom-field.js';
import 'Frontend/generated/jar-resources/lit-renderer.ts';
import '@vaadin/notification/theme/lumo/vaadin-notification.js';
import '@vaadin/app-layout/theme/lumo/vaadin-drawer-toggle.js';
import '@vaadin/side-nav/theme/lumo/vaadin-side-nav.js';
import '@vaadin/icon/theme/lumo/vaadin-icon.js';
import '@vaadin/side-nav/theme/lumo/vaadin-side-nav-item.js';
import '@vaadin/scroller/theme/lumo/vaadin-scroller.js';
import '@vaadin/app-layout/theme/lumo/vaadin-app-layout.js';
import '@vaadin/common-frontend/ConnectionIndicator.js';
import '@vaadin/vaadin-lumo-styles/color-global.js';
import '@vaadin/vaadin-lumo-styles/typography-global.js';
import '@vaadin/vaadin-lumo-styles/sizing.js';
import '@vaadin/vaadin-lumo-styles/spacing.js';
import '@vaadin/vaadin-lumo-styles/style.js';
import '@vaadin/vaadin-lumo-styles/vaadin-iconset.js';
import 'Frontend/generated/jar-resources/ReactRouterOutletElement.tsx';

injectGlobalCss($cssFromFile_0.toString(), 'CSSImport end', document);

injectGlobalCss($cssFromFile_1.toString(), 'CSSImport end', document);

const loadOnDemand = (key) => {
  const pending = [];
  if (key === 'e9fbeab5177a462a6c00cab486e546b62fc20a32272d27ee127867f8f354bdf7') {
    pending.push(import('./chunks/chunk-e6d7f827972099d1e59b0a79d9f08c81c88f89a0e2dab6ca0a7be73b04ff9898.js'));
  }
  if (key === 'b94b509b74b8a653817d13f919e3240919270a8a7f50e67716be145829bf41d5') {
    pending.push(import('./chunks/chunk-d2b9786817871d0d7852be20295f9a215500ae6a378e615a70774b3484b73664.js'));
  }
  if (key === '90ee41a6791bd5f0789a2c6f37ed7d943a0522af966a81883e2e75262eab4492') {
    pending.push(import('./chunks/chunk-d4a23a4be86fa54e29498111aa92dcbcbc6e1b61608add2d808adf71bd880f20.js'));
  }
  if (key === '0d13f2755f4593f6c0d9d11534a54f81b7d62172b637b92f80038394e59e0563') {
    pending.push(import('./chunks/chunk-94f9853f332096cc0db98eb4a1c443fce70f4b619fdfb177d28e36ab537cc364.js'));
  }
  if (key === '2514cd05fe6ab80ac04b61c39d9978450658f7beae6f638264e555eef88bfd5b') {
    pending.push(import('./chunks/chunk-94f9853f332096cc0db98eb4a1c443fce70f4b619fdfb177d28e36ab537cc364.js'));
  }
  if (key === '9239cb279be370fb1ce927279b2cc486467e57365ccf381657e050cbaef8b5b1') {
    pending.push(import('./chunks/chunk-2dd57d21b0098263ae92db0c1ad0654c24474921310457f2e82b523dbf3ce362.js'));
  }
  if (key === '87b6d2669034128f75863a889035c0c5219a8495e1cb0efab65ac531266d6f9b') {
    pending.push(import('./chunks/chunk-e6d7f827972099d1e59b0a79d9f08c81c88f89a0e2dab6ca0a7be73b04ff9898.js'));
  }
  if (key === '961ac858476cabe7607613df4c4212afd1d09368f578f0b347f0f2e8adab4dbf') {
    pending.push(import('./chunks/chunk-d2b9786817871d0d7852be20295f9a215500ae6a378e615a70774b3484b73664.js'));
  }
  if (key === '40d62675d36c09f9ae3ffaaf184ed6e51991cac9ef236d6b24d0b9e0a7725ded') {
    pending.push(import('./chunks/chunk-94f9853f332096cc0db98eb4a1c443fce70f4b619fdfb177d28e36ab537cc364.js'));
  }
  if (key === '4844c1b5fdd2c6edd078b9527b57590e0c5409f71554b0f55e5026bedf26ecce') {
    pending.push(import('./chunks/chunk-94f9853f332096cc0db98eb4a1c443fce70f4b619fdfb177d28e36ab537cc364.js'));
  }
  return Promise.all(pending);
}

window.Vaadin = window.Vaadin || {};
window.Vaadin.Flow = window.Vaadin.Flow || {};
window.Vaadin.Flow.loadOnDemand = loadOnDemand;
window.Vaadin.Flow.resetFocus = () => {
 let ae=document.activeElement;
 while(ae&&ae.shadowRoot) ae = ae.shadowRoot.activeElement;
 return !ae || ae.blur() || ae.focus() || true;
}