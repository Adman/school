#include <iostream>
#include <set>
#include <string>
#include <utility>


template <typename F, typename T>
class Relation {
private:
    std::set<std::pair<F, T> > el;
public:
    Relation() {
        el = {};
    }
    Relation(std::initializer_list<std::pair<F, T> > v) {
        el = (std::set<std::pair<F, T> >)v;
    }
    Relation(std::set<std::pair<F, T> > v) {
        el = v;
    }

    bool contains(std::pair<F, T> p) {
        return el.find(p) != el.end();
    }

    std::set<std::pair<F, T> > get_elements() const {
        return el;
    }

    void insert(Relation<F,T> rhs) {
        for (auto&& s : rhs.get_elements()) {
            insert(s);
        }
    }

    void insert(std::set<std::pair<F,T> > s) {
        el = s;
    }

    void insert(std::pair<F,T> p) {
        el.insert(p);
    }

    void erase(std::pair<F,T> p) {
        el.erase(p);
    }

    void erase_all() {
        el.erase(el.begin(), el.end());
    }
};

/* taken from http://coliru.stacked-crooked.com/a/dfbdf7cdde234414 */
namespace named_operator {
    template<class D>struct make_operator{};

    template<class T, char, class O> struct half_apply { T&& lhs; };

    template<class Lhs, class Op>
    half_apply<Lhs, '*', Op> operator*( Lhs&& lhs, make_operator<Op> ) {
        return {std::forward<Lhs>(lhs)};
    }

    template<class Lhs, class Op, class Rhs>
    auto operator*( half_apply<Lhs, '*', Op>&& lhs, Rhs&& rhs )
    -> decltype( invoke( std::forward<Lhs>(lhs.lhs), Op{}, std::forward<Rhs>(rhs) ) )
    {
        return invoke( std::forward<Lhs>(lhs.lhs), Op{}, std::forward<Rhs>(rhs) );
    }
}

namespace relation_ops {
    struct union_tag {};
    struct inters_tag {};
    struct compose_tag {};
    static named_operator::make_operator<union_tag> _union_;
    static named_operator::make_operator<inters_tag> _intersection_;
    static named_operator::make_operator<compose_tag> _compose_;

    template<class F, class T>
    Relation<F,T> invoke(Relation<F,T> lhs, union_tag, Relation<F,T> const& rhs) {
        lhs.insert(rhs);
        return std::move(lhs);
    }

    template<class F, class T>
    Relation<F,T> invoke(Relation<F,T> lhs, inters_tag, Relation<F,T> const& rhs) {
        std::set<std::pair<F, T> > rel = rhs.get_elements();
        for (auto&& s : lhs.get_elements()) {
            if (rel.find(s) == rel.end())
                lhs.erase(s);
        }

        return std::move(lhs);
    }

    template<class F, class T, class T2>
    Relation<F,T2> invoke(Relation<T,T2> lhs, compose_tag, Relation<F,T> const& rhs) {
        /* a compose b == a(b(x)) */
        std::set<std::pair<F,T> > rel = rhs.get_elements();
        std::set<std::pair<T,T2> > lel = lhs.get_elements();

        std::set<std::pair<F,T2> > out;

        for (auto&& s : rel) {
            for (auto&& t : lel) {
                if (s.second == t.first) {
                    std::pair<F,T2> p = {s.first, t.second};
                    out.insert(p);
                }
            }
        }

        lel.clear();
        lhs.insert(out);

        return std::move(lhs);
    }

}

using relation_ops::_union_;
using relation_ops::_intersection_;
using relation_ops::_compose_;

template <typename F>
Relation<F, F> operator^(Relation<F, F> rel, const int exp)
{
    if (exp == 0) {
        rel.erase_all();
        return std::move(rel);
    } else if (exp > 0) {
        // ^1 doesn't work
        Relation<F, F> out = rel;
        
        bool isnegative = exp < 0;

        int positive = isnegative ? -exp : exp;
        for (int i = 0; i < positive-1; i++) {
            out = out * _compose_ * rel;       
        }
        return std::move(out);
    } else if (exp < 0) {
        Relation<F, F> inv;
        for (auto&& s : rel.get_elements()) {
            std::pair<F, F> swapped(s.second, s.first);
            inv.insert(swapped);
        }
        return inv;
    }
}

template <typename F, typename T>
Relation<T, F> operator^(Relation<F, T> rel, const int exp)
{
    if (exp == 0) {
        Relation<T, F> ret = {};
        return std::move(ret);
    } else if (exp == -1) {
        Relation<T, F> inv;
        for (auto&& s : rel.get_elements()) {
            std::pair<T, F> swapped(s.second, s.first);
            inv.insert(swapped);
        }
        return inv;
    }
}

template <int N, typename F>
Relation<F, F> power(Relation<F, F> rel)
{
    if (N == 0) {
        rel.erase_all();
        return std::move(rel);
    } else if (N > 0) {
        // ^1 doesn't work
        Relation<F, F> out = rel;
        
        bool isnegative = N < 0;

        int positive = isnegative ? -N : N;
        for (int i = 0; i < positive-1; i++) {
            out = out * _compose_ * rel;       
        }
        return std::move(out);
    } else if (N < 0) {
        Relation<F, F> inv;
        for (auto&& s : rel.get_elements()) {
            std::pair<F, F> swapped(s.second, s.first);
            inv.insert(swapped);
        }
        return inv;
    }
}

template <int N, typename F, typename T>
Relation<T, F> power(Relation<F, T> rel)
{
    if (N == 0) {
        Relation<T, F> ret = {};
        return std::move(ret);
    } else if (N == -1) {
        Relation<T, F> inv;
        for (auto&& s : rel.get_elements()) {
            std::pair<T, F> swapped(s.second, s.first);
            inv.insert(swapped);
        }
        return inv;
    }
}

int main()
{
    Relation<int, std::string> r1 = {{1, "a"}, {1, "b"}, {2, "aa"}};
    Relation<int, std::string> r2 = {{5, "a"}, {1, "b"}, {2, "aa"}};
    Relation<int, int> r3 = {{1, 2}, {2, 2}, {2, 1}, {2, 3}};
    Relation<int, int> r4 = {{1, 1}, {2, 2}, {2, 3}};
    
    r1.contains({1, "a"});
    r1.contains({1, "aa"});
    //r1.contains({1, 1}); //this should fail

    auto r12a = r1 * _union_ * r2;
    auto r34a = r3 * _union_ * r4;
    //auto fail_union = r1 * _union_ * r3; // this should fail
    
    auto r12b = r1 * _intersection_ * r2;
    auto r34b = r3 * _intersection_ * r4;
    //auto fail_intersection = r1 * _intersection_ * r3; // this should fail

    auto r13c = r1 * _compose_ * r3;
    //auto fail_compose = r1 * _compose_ * r2; // this should fail

    auto r1d = r1^-1;
    auto r3d = r3^2;
    //auto r1e = r1^2; // this should fail (segfault in our case)

    auto r3f = power<2>(r3);

    return 0;
}
