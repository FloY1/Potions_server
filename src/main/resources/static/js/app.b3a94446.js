(function(t){function o(o){for(var a,s,i=o[0],l=o[1],p=o[2],u=0,d=[];u<i.length;u++)s=i[u],Object.prototype.hasOwnProperty.call(n,s)&&n[s]&&d.push(n[s][0]),n[s]=0;for(a in l)Object.prototype.hasOwnProperty.call(l,a)&&(t[a]=l[a]);c&&c(o);while(d.length)d.shift()();return r.push.apply(r,p||[]),e()}function e(){for(var t,o=0;o<r.length;o++){for(var e=r[o],a=!0,i=1;i<e.length;i++){var l=e[i];0!==n[l]&&(a=!1)}a&&(r.splice(o--,1),t=s(s.s=e[0]))}return t}var a={},n={app:0},r=[];function s(o){if(a[o])return a[o].exports;var e=a[o]={i:o,l:!1,exports:{}};return t[o].call(e.exports,e,e.exports,s),e.l=!0,e.exports}s.m=t,s.c=a,s.d=function(t,o,e){s.o(t,o)||Object.defineProperty(t,o,{enumerable:!0,get:e})},s.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},s.t=function(t,o){if(1&o&&(t=s(t)),8&o)return t;if(4&o&&"object"===typeof t&&t&&t.__esModule)return t;var e=Object.create(null);if(s.r(e),Object.defineProperty(e,"default",{enumerable:!0,value:t}),2&o&&"string"!=typeof t)for(var a in t)s.d(e,a,function(o){return t[o]}.bind(null,a));return e},s.n=function(t){var o=t&&t.__esModule?function(){return t["default"]}:function(){return t};return s.d(o,"a",o),o},s.o=function(t,o){return Object.prototype.hasOwnProperty.call(t,o)},s.p="/api/";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],l=i.push.bind(i);i.push=o,i=i.slice();for(var p=0;p<i.length;p++)o(i[p]);var c=l;r.push([0,"chunk-vendors"]),e()})({0:function(t,o,e){t.exports=e("56d7")},1:function(t,o){},"56d7":function(t,o,e){"use strict";e.r(o);var a=e("2b0e"),n=e("28dd");a["a"].use(n["a"]);var r=function(){var t=this,o=t.$createElement,e=t._self._c||o;return e("v-app",[e("app-bar"),e("v-content",[e("add-potion")],1)],1)},s=[],i=e("dd38"),l=function(){var t=this,o=t.$createElement,e=t._self._c||o;return e("v-card",{staticClass:"mx-auto my-3 pa-6",attrs:{width:"500px"}},[[e("v-container",{attrs:{fluid:""}},[e("v-form",{staticClass:"text-center"},[e("span",[t._v("Новое зелье")]),e("v-row",{staticClass:"py-0 ma-0"},[e("v-col",{staticClass:"py-0 ma-0",attrs:{cols:"12"}},[e("v-text-field",{attrs:{label:"Bvz"},model:{value:t.potion.name,callback:function(o){t.$set(t.potion,"name",o)},expression:"potion.name"}})],1),e("v-row",{staticClass:"py-0 mx-3 my-0 "},[e("v-col",{attrs:{cols:"3"}},[e("v-text-field",{attrs:{label:"значение"},model:{value:t.potion.p1,callback:function(o){t.$set(t.potion,"p1",o)},expression:"potion.p1"}})],1),e("v-col",{attrs:{cols:"3"}},[e("v-text-field",{attrs:{label:"значение"},model:{value:t.potion.p2,callback:function(o){t.$set(t.potion,"p2",o)},expression:"potion.p2"}})],1),e("v-col",{attrs:{cols:"3"}},[e("v-text-field",{attrs:{label:"значение"},model:{value:t.potion.p3,callback:function(o){t.$set(t.potion,"p3",o)},expression:"potion.p3"}})],1),e("v-col",{attrs:{cols:"3"}},[e("v-text-field",{attrs:{label:"значение"},model:{value:t.potion.p4,callback:function(o){t.$set(t.potion,"p4",o)},expression:"potion.p4"}})],1)],1),e("v-col",{attrs:{cols:"12"}},[e("v-progress-linear",{attrs:{color:"light-blue",value:t.potion.p1/10*100}})],1),e("v-col",{attrs:{cols:"12"}},[e("v-progress-linear",{attrs:{color:"light-green darken-4",value:t.potion.p2/10*100}})],1),e("v-col",{attrs:{cols:"12"}},[e("v-progress-linear",{attrs:{color:"lime",value:t.potion.p3/10*100}})],1),e("v-col",{attrs:{cols:"12"}},[e("v-progress-linear",{attrs:{color:"deep-orange",striped:"",value:t.potion.p4/10*100}})],1),e("v-col",{attrs:{cols:"12"}},[e("v-textarea",{attrs:{solo:"",name:"input-7-4",label:"Описание"},model:{value:t.potion.description,callback:function(o){t.$set(t.potion,"description",o)},expression:"potion.description"}})],1),e("v-col",{attrs:{cols:"6"}},[e("v-btn",{attrs:{text:"",large:"",color:"primary"},on:{click:t.saveButton}},[t._v("\n                            Добавить\n                        ")])],1),e("v-col",{attrs:{cols:"6"}},[e("v-btn",{attrs:{text:"",large:"",color:"error"}},[t._v("Отменить")])],1)],1)],1)],1)]],2)},p=[],c=e("2f62"),u={data(){return{potion:{name:"",description:"",p1:1,p2:1,p3:1,p4:1}}},methods:{...Object(c["b"])(["addPotion"]),saveButton(){const t={name:this.potion.name,description:this.potion.description,p1:this.potion.p1,p2:this.potion.p2,p3:this.potion.p3,p4:this.potion.p4};this.addPotion(t)}}},d=u,v=e("2877"),f=e("6544"),b=e.n(f),m=e("8336"),h=e("b0af"),x=e("62ad"),g=e("a523"),y=e("4bd4"),w=e("8e36"),_=e("0fd9"),V=e("8654"),O=e("a844"),j=Object(v["a"])(d,l,p,!1,null,"08fcf0c3",null),C=j.exports;b()(j,{VBtn:m["a"],VCard:h["a"],VCol:x["a"],VContainer:g["a"],VForm:y["a"],VProgressLinear:w["a"],VRow:_["a"],VTextField:V["a"],VTextarea:O["a"]});var P={name:"App",components:{AppBar:i["default"],AddPotion:C},data:()=>({})},k=P,$=e("7496"),B=e("a75b"),S=Object(v["a"])(k,r,s,!1,null,null,null),T=S.exports;b()(S,{VApp:$["a"],VContent:B["a"]});const A=a["a"].resource("admin/potion{/id}");var M={add:t=>A.save({},t)};a["a"].use(c["a"]);var E=new c["a"].Store({state:{},mutations:{},actions:{async addPotion(t){console.log(t.name);const o=await M.add(t);o.json()}}}),F=e("f309");a["a"].use(F["a"]);var J=new F["a"]({icons:{iconfont:"mdi"}});ru.maveri.potions.config.productionTip=!1,new a["a"]({store:E,vuetify:J,render: t=>t(T)}).$mount("#app")},5983:function(t, o, e){"use strict";var a=e("8374"),n=e.n(a);o["default"]=n.a},8374:function(t, o){},"92ca":function(t, o, e){"use strict";var a=function(){var t=this,o=t.$createElement,e=t._self._c||o;return e("v-app-bar",{attrs:{app:""}},[e("v-toolbar-title",{staticClass:"headline "},[e("span",{staticClass:"text-uppercase"},[t._v("Зелья ")]),e("span",{staticClass:"font-weight-light"},[t._v("смешивай или умри")])]),e("v-spacer"),e("v-btn",{attrs:{icon:""}},[e("v-icon",[t._v("mdi-plus-circle")])],1)],1)},n=[];e.d(o,"a",(function(){return a})),e.d(o,"b",(function(){return n}))},dd38:function(t,o,e){"use strict";var a=e("92ca"),n=e("5983"),r=e("2877"),s=e("6544"),i=e.n(s),l=e("40dc"),p=e("8336"),c=e("132d"),u=e("2fa4"),d=e("2a7f"),v=Object(r["a"])(n["default"],a["a"],a["b"],!1,null,null,null);o["default"]=v.exports,i()(v,{VAppBar:l["a"],VBtn:p["a"],VIcon:c["a"],VSpacer:u["a"],VToolbarTitle:d["a"]})}});
//# sourceMappingURL=app.b3a94446.js.map