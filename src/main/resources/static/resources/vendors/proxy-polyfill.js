(function () {
	function n() {
		function v() {
			return null
		}

		function l(a) {
			return a ? "object" === typeof a || "function" === typeof a : !1
		}

		function p(a) {
			if (null !== a && !l(a)) throw new TypeError("Object prototype may only be an Object or null: " + a);
		}

		var q = null, e = Object, w = !!e.create || !({__proto__: null} instanceof e),
			A = e.create || (w ? function (a) {
				p(a);
				return {__proto__: a}
			} : function (a) {
				function c() {
				}

				p(a);
				if (null === a) throw new SyntaxError("Native Object.create is required to create objects with null prototype");
				c.prototype = a;
				return new c
			}),
			B = e.getPrototypeOf || ([].__proto__ === Array.prototype ? function (a) {
				a = a.__proto__;
				return l(a) ? a : null
			} : v);
		var m = function (a, c) {
			function k() {
			}

			if (void 0 === (this && this instanceof m ? this.constructor : void 0)) throw new TypeError("Constructor Proxy requires 'new'");
			if (!l(a) || !l(c)) throw new TypeError("Cannot create proxy with a non-object as target or handler");
			q = function () {
				a = null;
				k = function (b) {
					throw new TypeError("Cannot perform '" + b + "' on a proxy that has been revoked");
				}
			};
			setTimeout(function () {
				q = null
			}, 0);
			var g =
				c;
			c = {get: null, set: null, apply: null, construct: null};
			for (var h in g) {
				if (!(h in c)) throw new TypeError("Proxy polyfill does not support trap '" + h + "'");
				c[h] = g[h]
			}
			"function" === typeof g && (c.apply = g.apply.bind(g));
			g = B(a);
			var r = !1, t = !1;
			if ("function" === typeof a) {
				var f = function () {
					var b = this && this.constructor === f, d = Array.prototype.slice.call(arguments);
					k(b ? "construct" : "apply");
					return b && c.construct ? c.construct.call(this, a, d) : !b && c.apply ? c.apply(a, this, d) : b ? (d.unshift(a), new (a.bind.apply(a, d))) : a.apply(this,
						d)
				};
				r = !0
			} else a instanceof Array ? (f = [], t = !0) : f = w || null !== g ? A(g) : {};
			var x = c.get ? function (b) {
				k("get");
				return c.get(this, b, f)
			} : function (b) {
				k("get");
				return this[b]
			}, C = c.set ? function (b, d) {
				k("set");
				c.set(this, b, d, f)
			} : function (b, d) {
				k("set");
				this[b] = d
			}, y = {};
			e.getOwnPropertyNames(a).forEach(function (b) {
				if (!((r || t) && b in f)) {
					var d = e.getOwnPropertyDescriptor(a, b);
					e.defineProperty(f, b, {enumerable: !!d.enumerable, get: x.bind(a, b), set: C.bind(a, b)});
					y[b] = !0
				}
			});
			h = !0;
			if (r || t) {
				var D = e.setPrototypeOf || ([].__proto__ ===
				Array.prototype ? function (b, d) {
					p(d);
					b.__proto__ = d;
					return b
				} : v);
				g && D(f, g) || (h = !1)
			}
			if (c.get || !h) for (var u in a) y[u] || e.defineProperty(f, u, {get: x.bind(a, u)});
			e.seal(a);
			e.seal(f);
			return f
		};
		m.revocable = function (a, c) {
			return {proxy: new m(a, c), revoke: q}
		};
		return m
	};var z = "undefined" !== typeof process && "[object process]" === {}.toString.call(process) || "undefined" !== typeof navigator && "ReactNative" === navigator.product ? global : self;
	z.Proxy || (z.Proxy = n(), z.Proxy.revocable = z.Proxy.revocable);
})();