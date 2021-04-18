#!/usr/bin/env python
#coding:utf-8

import os


def rename_files(pfix='bg_', path=None):
    """
    批量更新文件夹名称
    :param pfix:
    :param path:
    :return:
    """

    if not path:
        path = os.getcwd()

    for fi in os.listdir(path):
        if fi.startswith('屏幕快照'):
            os.renames(fi, fi.replace('屏幕快照', pfix).replace('-', '').replace(' ', '').replace('.', '', 2).strip())

if __name__ == '__main__':

    rename_files()
