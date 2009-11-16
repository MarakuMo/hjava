package org.huys.dp.behavioral.iterator;

import java.util.TreeSet;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Hashtable;
import java.util.Enumeration;

class SomeClassWithDataBefore
{
    private TreeSet < Integer > m_data = new TreeSet < Integer > ();

    public void add(int in)
    {
        m_data.add(in);
    }

    public Collection get_data()
    {
        return m_data;
    }

    public static void test()
    {
        SomeClassWithDataBefore some_object = new SomeClassWithDataBefore();
        for (int i = 9; i > 0; --i) {
            some_object.add(i);
        }

        Collection data = some_object.get_data();
        for (java.util.Iterator it = data.iterator(); it.hasNext();) {
            System.out.print(it.next() + "  ");
        }

        System.out.println();

        // Do we really want a client to be able to
        // trash encapsulated state?
        data.clear();
        data = some_object.get_data();
        System.out.println("size of data is " + data.size());
    }
}

class SomeClassWithDataAfter
{
    private TreeSet < Integer > m_data = new TreeSet < Integer > ();

    public class Iterator
    {
        private SomeClassWithDataAfter m_collection;
        private java.util.Iterator < Integer > m_it;
        private int m_current;
        public Iterator(SomeClassWithDataAfter in)
        {
            m_collection = in;
        }
        public void first()
        {
            m_it = m_collection.m_data.iterator();
            next();
        }
        public void next()
        {
            try
            {
                m_current = m_it.next();
            }
            catch (NoSuchElementException ex)
            {
                m_current =  - 999;
            }
        }
        public boolean is_done()
        {
            return m_current ==  - 999;
        }
        public int current_item()
        {
            return m_current;
        }
    }

    public void add(int in)
    {
        m_data.add(in);
    }
    public Iterator create_iterator()
    {
        return new Iterator(this);
    }

    public static void test()
    {
        SomeClassWithDataAfter some_object = new SomeClassWithDataAfter();
        for (int i = 9; i > 0; --i) {
            some_object.add(i);
        }

        // get_data() has been removed.
        // Client has to use Iterator.
        SomeClassWithDataAfter.Iterator it1 = some_object.create_iterator();
        SomeClassWithDataAfter.Iterator it2 = some_object.create_iterator();

        for (it1.first(); !it1.is_done(); it1.next()) {
            System.out.print(it1.current_item() + "  ");
        }
        System.out.println();

        // Two simultaneous iterations
        for (it1.first(), it2.first(); !it1.is_done(); it1.next(), it2.next()) {
            System.out.print(it1.current_item() + " " + it2.current_item() + "  ");
        }
        System.out.println();
    }
}

class IntSet {
    private Hashtable<Integer, String> ht = new Hashtable<Integer, String>();

    // 1. Design an internal "iterator" class for the "collection" class
    public static class Iterator {
        private IntSet set;
        private Enumeration e;
        private Integer     current;
        public Iterator( IntSet in ) { set = in; }
        public void first() { e = set.ht.keys();  next(); }
        public boolean isDone() { return current == null; }
        public int currentItem() { return current.intValue(); }
        public void next() {
            try {
                current = (Integer) e.nextElement();
            } catch (NoSuchElementException e) {
                current = null;
            }
        }
    }

    public void add(int in) { ht.put( new Integer( in ), "null" ); }
    public boolean isMember(int i) { return ht.containsKey(new Integer(i)); }
    public Hashtable getHashtable() { return ht; }
    // 2. Add a createIterator() member to the collection class
    public Iterator createIterator() { return new Iterator( this ); }

    public static void test()
    {
        IntSet set = new IntSet();
        for (int i=2; i < 10; i += 2) set.add( i );
        for (int i=1; i < 9; i++) {
            System.out.print( i + "-" + set.isMember( i ) + "  " );
        }
        // 3. Clients ask the collection object to create many iterator objects
        IntSet.Iterator it1 = set.createIterator();
        IntSet.Iterator it2 = set.createIterator();

        // 4. Clients use the first(), isDone(), next(), currentItem() protocol
        System.out.print( "\nIterator:    " );
        for ( it1.first(), it2.first();  ! it1.isDone();  it1.next(), it2.next() ) {
            System.out.print( it1.currentItem() + " " + it2.currentItem() + "  " );
        }
        // Java uses a different collection traversal "idiom" called Enumeration
        System.out.print( "\nEnumeration: " );
        for (Enumeration e = set.getHashtable().keys(); e.hasMoreElements(); ) {
            System.out.print( e.nextElement() + "  " );
        }
        System.out.println();
    }
}

public class IteratorDemo
{
    public static void main(String[] args)
    {
        SomeClassWithDataBefore.test();
        SomeClassWithDataAfter.test();
        IntSet.test();
    }
}
