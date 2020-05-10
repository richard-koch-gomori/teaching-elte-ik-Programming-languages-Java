

class IntList
{
    private int[] data;
    private int currentSize, maxSize;

    public IntList(int maxSize)
    {
        data = new int[maxSize];
        this.maxSize = maxSize;
        //currentSize = 0;
    }

    public void add(int item)
    {
        if (currentSize == maxSize)
        {
            throw new IllegalStateException("IntList is full");
        }
        data[currentSize++] = item;
    }

    public void concat(IntList that)
    {
        if (currentSize + that.currentSize > maxSize)
        {
            throw new IllegalStateException("IntList is full");
        }
        for (int idx = 0; idx < that.currentSize; ++idx)
        {
            data[currentSize + idx] = that.data[idx];
        }
        this.currentSize += that.currentSize;
    }

    public String toString()
    {
        if (currentSize <= 0)
        {
            return "empty";
        }
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < currentSize; ++idx)
        {
            int item = data[idx];
            sb.append(item);
            sb.append(",");
        }
        return sb.toString();
    }

    public void removeItemsGreaterThan(int limit)
    {
        int[] newData = new int[maxSize];
        int newCurrentSize = 0;

        for (int idx = 0; idx < currentSize; ++idx)
        {
            int item = data[idx];
            if (item <= limit)
            {
                newData[newCurrentSize++] = item;
            }
        }

        this.data = newData;
        this.currentSize = newCurrentSize;
    }
}

